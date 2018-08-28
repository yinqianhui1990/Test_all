package com.Exception;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/8/3.
 */
public class DefaultExceptionHandler implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        System.out.println("This is exception handler method!");
        System.out.println("This is exception:"+e.getMessage());
        ModelAndView modelAndView = new ModelAndView();
       /* modelAndView.addObject("message", e.getMessage());
        modelAndView.setViewName("exception");
        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("code", "1000001");
        attributes.put("msg", e.getMessage());
        view.setAttributesMap(attributes);
        modelAndView.setView(view);*/
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.setCharacterEncoding("UTF-8");
        try {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("message",e.getMessage());
            httpServletResponse.getWriter().print(jsonObject);
            httpServletResponse.getWriter().flush();
            httpServletResponse.getWriter().close();
        } catch (IOException ex) {
            e.printStackTrace();
        }
        return null;

    }
}
