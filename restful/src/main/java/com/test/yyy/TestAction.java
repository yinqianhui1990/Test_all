package com.test.yyy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ThinkPad on 2017/1/16.
 */
@Controller
@RequestMapping(value="/test")
public class TestAction {

    @RequestMapping(value="/index")
    public String index(){
        System.out.println("index--");
        return "index";
    }
    @RequestMapping(value="/user/{name}",method= RequestMethod.GET)
    @ResponseBody
    public Map<String,String> user(@PathVariable String name){
        Map<String,String> map=new HashMap<String,String>();
        map.put("name",name);
        System.out.println("getuser"+name);
        return map;
    }

    @RequestMapping(value="/users",method= RequestMethod.GET)
    @ResponseBody
    public List<String> getUsers(){
        System.out.println("getUsers");
        List<String>list=new ArrayList<String>();
        list.add("123");
        list.add("321");
        return list;
    }

    @RequestMapping(value="/user",method= RequestMethod.PUT)
    @ResponseBody
    public Map<String,String> updateUser(@RequestBody String name){
        Map<String,String> map=new HashMap<String,String>();
        map.put("name",name);
        System.out.println("UpdateUser:"+name);
        return map;
    }

    @RequestMapping(value="/user",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,String> AddUser(@RequestBody String name){
        Map<String,String> map=new HashMap<String,String>();
        map.put("name",name);
        System.out.println("addUser:"+name);
        return map;
    }

    @RequestMapping(value="/user",method= RequestMethod.DELETE)
    @ResponseBody
    public Map<String,String> delUser(@RequestBody String name){
        Map<String,String> map=new HashMap<String,String>();
        map.put("name",name);
        System.out.println("delUser:"+name);
        return map;
    }


}
