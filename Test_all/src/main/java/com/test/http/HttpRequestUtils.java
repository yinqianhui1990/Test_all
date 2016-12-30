package com.test.http;

/**
 * Created by ThinkPad on 2016/5/3.
 */
import  com.alibaba.fastjson.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import java.io.IOException;
import java.net.URLDecoder;


public class HttpRequestUtils {
   // private static Logger logger = LoggerFactory.getLogger(HttpRequestUtils.class);    //日志记录

    /**
     * httpPost
     * @param url  路径
     * @param jsonParam 参数
     * @return
     */
    public static JSONObject httpPost(String url,JSONObject jsonParam){
        return httpPost(url, jsonParam, false);
    }

    /**
     * post请求
     * @param url         url地址
     * @param jsonParam     参数
     * @param noNeedResponse    不需要返回结果
     * @return
     */
    public static JSONObject httpPost(String url,JSONObject jsonParam, boolean noNeedResponse){
        //post请求返回结果
        CloseableHttpClient client = HttpClients.createDefault();
        JSONObject jsonResult = null;
        HttpPost post = new HttpPost(url);
        try {
            if (null != jsonParam) {
                //解决中文乱码问题
                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                post.setEntity(entity);
            }
            HttpResponse result = client.execute(post);
            url = URLDecoder.decode(url, "UTF-8");
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == 200) {
                String str = "";
                try {
                    /**读取服务器返回过来的json字符串数据**/
                    str = EntityUtils.toString(result.getEntity());
                    if (noNeedResponse) {
                        return null;
                    }
                    /**把json字符串转换成json对象**/
                    jsonResult = JSONObject.parseObject(str);
                    System.out.println("===="+jsonResult);
                } catch (Exception e) {
                   System.out.println("post请求提交失败:" + url);
                }
            }
        } catch (IOException e) {
            System.out.println("post请求提交失败:" + url);
        }
        return jsonResult;
    }


    /**
     * 发送get请求
     * @param url    路径
     * @return
     */
    public static JSONObject httpGet(String url){
        //get请求返回结果
        JSONObject jsonResult = null;
        CloseableHttpResponse response=null;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            //发送get请求
            HttpGet request = new HttpGet(url);
            response= client.execute(request);

            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == 200) {
                /**读取服务器返回过来的json字符串数据**/
                String strResult = EntityUtils.toString(response.getEntity());
                /**把json字符串转换成json对象**/
                System.out.println(strResult);
                jsonResult = JSONObject.parseObject(strResult);
                url = URLDecoder.decode(url, "UTF-8");
            } else {
                System.out.println("get请求提交失败:" + url);
            }
        } catch (IOException e) {
            System.out.println("get请求提交失败:" + url);
        }
        return jsonResult;
    }
    public  static  void main(String[] argss){
        HttpRequestUtils hu=new HttpRequestUtils();
       hu.httpGet("http://localhost:8080/mnis/nur/patientGlance/getPateintBedList?deptCode=5042");
      // String param="{barCode:'I3213'}";
      // JSON.parseObject(param);
      //  hu.httpPost("http://localhost:8080/infusion/nur/infusionmanager/getInfusionExecOrderInfoByBarCode",JSON.parseObject(param));
       /* String test="{name:123456}";
        JSONObject jsonObject=JSON.parseObject(test);
        System.out.println(jsonObject.get("name"));*/


    }
}