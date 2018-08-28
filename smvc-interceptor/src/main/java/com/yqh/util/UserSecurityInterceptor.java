package com.yqh.util;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/5/15.
 */
public class UserSecurityInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("WrongCodeInterceptor, preHandle......");
        String url=request.getRequestURL().toString();
        if(url.contains("1")){
            System.out.println("被拦截了！");
            return false;
        }
            return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        System.out.println("WrongCodeInterceptor, postHandle......");
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("WrongCodeInterceptor, afterCompletion......");
    }
}
