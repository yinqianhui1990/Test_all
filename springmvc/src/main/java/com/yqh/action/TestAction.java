package com.yqh.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yqh.model.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Controller

public class TestAction {
	//跳转页面
    @RequestMapping("/test")  
    public String loginView() {  
       System.out.println("test!");       
        return "index";  
    }  
    
    //通过Map，html可以ajax//通过配合@ResponseBody 以json数据返回（适合做即时校验）；
    //记得添加jackson-core-lgpl-1.8.5.jar 和jackson-mapper-lgpl-1.8.5.jar
    @RequestMapping(value="/index2",method=RequestMethod.GET)  
    @ResponseBody  
    public Map<String,String> index2(){  
    	Map<String,String> map=new HashMap<String,String>();
    	map.put("name", "lei tower 二货");  
    	System.out.println("index2");
        return map;  
    } 
    
    @RequestMapping(value="/getUser",method=RequestMethod.POST)  
    @ResponseBody  
    public User getUser(){  
    	User user=new User();
    	user.setId(1);
    	user.setUserName("yiqianhui");
    	user.setPassWord("123123");
    	System.out.println("getUser");
        return user;  
    } 
    
    //字符串接收post
    @RequestMapping(value= "/requestParam" , method= RequestMethod.POST)
    @ResponseBody  
   // @RequestParam( "userName" ) @RequestParam( "passWord" )
    public User getForm(String userName, String passWord) {  
    	System.out.println("requestParam");
    	System.out.println(userName+"=="+passWord);
    	User user=new User();
    	user.setId(2);
    	user.setUserName(userName);
    	user.setPassWord(passWord);
        return user ;
    }
    //字符串接收get
    @RequestMapping(value= "/requestParamGet" , method= RequestMethod.GET)
    @ResponseBody
    // @RequestParam( "userName" ) @RequestParam( "passWord" )
    public User getFormTest(String userName, String passWord) {
        System.out.println("requestParam");
        System.out.println(userName+"=="+passWord);
        User user=new User();
        user.setId(2);
        user.setUserName(userName);
        user.setPassWord(passWord);
        return user ;
    }
    //具体对象接受
    @RequestMapping(value = "/sendUser", method = RequestMethod.POST)   
    @ResponseBody  
    public Map<String,String> sendUser(@RequestBody User user) {
       System.out.println("sendUser");
       System.out.println("user:"+user.getUserName()+"=="+user.getPassWord());
       Map<String,String> map=new HashMap<String,String>();
       map.put("name", "参数已经传到");
       return map;

    }

    //具体对象接受
    @RequestMapping(value = "/sendUser2", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> sendUser2(  User user) {
        System.out.println("sendUser"+user);
        System.out.println("user:"+user.getUserName()+"=="+user.getPassWord());
        Map<String,String> map=new HashMap<String,String>();
        map.put("name", "参数已经传到222");
        return map;

    }
    
    //map接受
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST )  
    @ResponseBody 
    public Map<String,String> saveUser(@RequestBody Map<String,String>  user) { 
         System.out.println("COMING");

    	 System.out.println("name=="+user.get("userName"));
         System.out.println("pwd=="+user.get("passWord"));                 
         return user;
    }

  //  12、文件上传功能实现 配置文件上传解析器
    @RequestMapping(value={"/upLoad"},method=RequestMethod.POST)
    @ResponseBody
    public String upLoad(
                               @RequestParam("test") MultipartFile file,
                               HttpServletRequest request
    ) throws IOException {
        if(!file.isEmpty()){
            ServletContext sc = request.getSession().getServletContext();
            String dir = sc.getRealPath("/upload");    //设定文件保存的目录

            String filename = file.getOriginalFilename();    //得到上传时的文件名
            FileUtils.writeByteArrayToFile(new File(dir, filename), file.getBytes());



            System.out.println("upload over. "+ filename);
        }
        return "upload over." ;
    }

    @RequestMapping(value="/testException")
    public String  testException(){

        //throw  new Exception("我困了");
        int a=1/0;
return "123";
    }

}
