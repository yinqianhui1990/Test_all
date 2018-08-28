package com.test.TestAction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ThinkPad on 2017/1/17.
 */
@RestController
@EnableAutoConfiguration
public class TestAction {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/now")
    String hehe() {
        return "now:" + (new Date()).toString();
    }

    @RequestMapping("/say/{name}")
    String say(@PathVariable String name) {

        return "你好:" + name;
    }

    @RequestMapping("/login/{name}/{password}")
    String say(@PathVariable String name,@PathVariable String password) {

        return "你好:" + name+password;
    }


    @RequestMapping(value = "/login", method= RequestMethod.POST)
    @ResponseBody
    String login( String name , String passWord) {
        System.out.println("name={}"+name+"pwd={}"+passWord);
        return "你好:" + name+"--"+passWord;
    }

    @RequestMapping(value = "/getDate", method= RequestMethod.GET)
    @ResponseBody
    Map getDate( ) {
       Map<String ,Object> a= new HashMap();
        a.put("date", new Date());
        return a;
    }

    public static void main(String[] args) {
        SpringApplication.run(TestAction.class, args);
    }
}
