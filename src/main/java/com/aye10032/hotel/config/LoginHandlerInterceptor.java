package com.aye10032.hotel.config;

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
        Object LoginUser = request.getSession().getAttribute("LoginUser");
        String path = request.getServletPath();
        if (path.contains("/manager/")) {
            return true;
        } else {
            System.out.println(path);
            if (LoginUser == null) {
                request.setAttribute("msg", "没有权限，请登录");
                request.getRequestDispatcher("/login.html").forward(request, response);
                return false;

            } else {
                return true;
            }
        }
    }
}
