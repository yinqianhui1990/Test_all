package com.yqh.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/5/15.
 */
@Controller
public class TestAction {

    @RequestMapping("/test")
    public String loginView() {
        System.out.println("test!");
        return "index";
    }

    @RequestMapping(value = "/index2", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> index2() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "lei tower 二货");
        System.out.println("index2");
        return map;
    }

    @RequestMapping(value ="/testBody", method = RequestMethod.POST)
    @ResponseBody
    public String testBody(HttpServletRequest request) {
        BufferedReader br;
        StringBuilder sb = null;
        String reqBody = null;
        try {
            br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String line = null;
            sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            reqBody = URLDecoder.decode(sb.toString(), "UTF-8");
            System.out.println(reqBody);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "hello";
    }
}
