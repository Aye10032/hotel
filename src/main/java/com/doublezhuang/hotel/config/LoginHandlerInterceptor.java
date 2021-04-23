package com.doublezhuang.hotel.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: hotel
 * @className: LoginHandlerInterseptor
 * @Description: 登录拦截器
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/4/23 上午 11:23
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}