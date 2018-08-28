package com.test.jedis;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public final class RedisUtil {

	// Redis服务器IP
	private static String ADDR;

	// Redis的端口号
	private static int PORT;

	// 访问密码
	 private static String AUTH  ;

	// 可用连接实例的最大数目，默认值为8；
	// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
	private static int MAX_ACTIVE ;

	// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
	private static int MAX_IDLE ;

	// 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
	private static int MAX_WAIT;

	private static int TIMEOUT;

	// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
	private static boolean TEST_ON_BORROW ;
	private static boolean TEST_ON_RETURN ;

	private static JedisPool jedisPool = null;
	static final Logger LOGGER = LoggerFactory.getLogger(RedisUtil.class);

	/**
	 * 初始化Redis连接池
	 */

	public static void initJedisPool() {
		try {
			Properties prop = new Properties();

			InputStream in =RedisUtil.class.getClassLoader().getResourceAsStream("redis.properties");
			prop.load(in);
			ADDR=prop.getProperty("redis.pool.host");
			PORT=Integer.parseInt(prop.getProperty("redis.pool.port"));
			MAX_ACTIVE=Integer.parseInt(prop.getProperty("redis.poolConfig.maxActive"));
			MAX_IDLE=Integer.parseInt(prop.getProperty("redis.poolConfig.maxIdle"));
			MAX_WAIT=Integer.parseInt(prop.getProperty("redis.poolConfig.maxWait"));
			TEST_ON_BORROW=Boolean.parseBoolean(prop.getProperty("redis.poolConfig.testOnBorrow"));
			TIMEOUT=Integer.parseInt(prop.getProperty("redis.pool.timeOut"));
			AUTH=prop.getProperty("redis.pool.password");
			TEST_ON_RETURN=Boolean.parseBoolean(prop.getProperty("redis.poolConfig.testOnReturn"));

			if (jedisPool == null) {
				JedisPoolConfig config = new JedisPoolConfig();
				config.setMaxActive(MAX_ACTIVE);
				config.setMaxIdle(MAX_IDLE);
				config.setMaxWait(MAX_WAIT);
				config.setTestOnBorrow(TEST_ON_BORROW);
				config.setTestOnReturn(TEST_ON_RETURN);
				if(AUTH.equals("")||AUTH==null) {
					jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT);
				}else{
					jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT,AUTH);
				}

			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}


	/**
	 * 获取Jedis实例
	 * 
	 * @return
	 */
	public synchronized static Jedis getJedis() {
		try {
			if (jedisPool != null) {
			} else {
				initJedisPool();
			}
			return jedisPool.getResource();
		} catch (Exception e) {
			LOGGER.error("获取jedis异常:"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取批处理
	 * 
	 * @return
	 */
	public static Pipeline getPipeline() {
		Pipeline pipeline = null;
		Jedis jedis = getJedis();
		if ( jedis!= null) {
			pipeline = jedis.pipelined();
		}
		return pipeline;
	}
	
	/**
	 * 释放jedis资源
	 * 
	 * @param jedis
	 */
	public synchronized static void returnResource(final Jedis jedis) {
		if (jedis != null) {
			jedisPool.returnResource(jedis);
		}
	}

	/**
	 * 获取数据
	 * 
	 * @param key
	 * @return
	 */
	public static String get(String key) {
		String value = null;
		Jedis jedis = null;
		try {
			jedis = getJedis();
			value = jedis.get(key);
		} catch (Exception e) {
			// 释放redis对象
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			// 返还到连接池
			returnResource(jedis);
		}
		return value;
	}

	/**
	 * 设置数据
	 * 
	 * @param key
	 *            value
	 * 
	 */
	public static void set(String key, String value) {

		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.set(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
	}

	

	/**
	 * 保存java对象
	 * 
	 * @param key
	 *            obj
	 * 
	 */
	public static void setJavaObj(String key, Object obj) {
		String jsonStr = JSON.toJSONString(obj);
		set(key, jsonStr);
	}

	/**
	 * 还原简单java对象
	 * 
	 * @param key
	 *            clazz
	 */
	public static <T> T getSimpleObj(String key, Class<T> clazz) {
		String jsonStr = get(key);
		return JSON.parseObject(jsonStr, clazz);
	}

	/**
	 * 还原java -List对象
	 * 
	 * @param key
	 *            clazz
	 * 
	 */
	public static <T> List<T> getListObj(String keyList, Class<T> clazz) {
		String jsonStr = get(keyList);
		return JSON.parseArray(jsonStr, clazz);
	}


	public static void main(String[] args) throws InterruptedException {

		// ---------------存取字符串-----------------------
		/*RedisUtil.set("name", "yinzaige");
		System.out.println(RedisUtil.get("name"));*/


		/*
		 * -------------------存取单一的对象 -----------------------------------
		 */
	/*	Map<String, String> map = new HashMap<String, String>();
		map.put("test", "测试");
		map.put("dev", "开发");
		System.out.println(map);
		RedisUtil.setJavaObj("map", map);
		@SuppressWarnings("unchecked")
		Map<String, String> map2 = RedisUtil.getSimpleObj("map", Map.class);
		System.out.println(map2.get("test"));*/

		/*User us = new User();
		us.setName("张三");
		us.setAge(18);
		us.setId(100);

		RedisUtil.setJavaObj("us", us);
		System.out.println("name=="
				+ RedisUtil.getSimpleObj("us", User.class).getName());

		// -------------------存取list--------------------------------------

		List<User> list = new ArrayList<User>();
		for (int i = 0; i < 100; i++) {
			User user = new User();
			user.setId(i);
			user.setName("老" + i);
			user.setAge(i / 10);
			list.add(user);
		}
		RedisUtil.setJavaObj("ulist", list);

		// 1.转换后list里面的对象还是是字符串，并未还原，还需手动转换里面的对象
		List<User> lu = RedisUtil.getSimpleObj("ulist", List.class);
		System.out.println(lu.size() + "--------" + lu.get(1));

		// 2.需要自己转换
		lu = JSON.parseArray(RedisUtil.get("ulist"), User.class);
		System.out.println(lu.size() + "--------" + lu.get(1));

		// 3.将2的方式封装了一下，直接得到还原的list以及里面的对象
		lu = RedisUtil.getListObj("ulist", User.class);
		System.out.println(lu.size() + "--------" + lu.get(1));
		
		
		for (int k = 0; k < lu.size(); k++) {
			System.out.println("name=" + lu.get(k).getName() + "  age="
					+ lu.get(k).getAge());
		}
		// /=============================================
		UserGroup ug = new UserGroup();
		ug.setUsers(list);
		ug.setName("中队");
		RedisUtil.setJavaObj("ug", ug);
		System.out.println(RedisUtil.get("ug"));
		System.out.println(RedisUtil.getSimpleObj("ug", UserGroup.class));
		System.out.println(RedisUtil.getSimpleObj("ug", UserGroup.class)
				.getUsers().get(1).getName());*/

		//------------------------------
		Jedis jedis =RedisUtil.getJedis();
		jedis.set("name","888");
		RedisUtil.returnResource(jedis);
		System.out.println("===="+jedis.get("name"));
	}
}
