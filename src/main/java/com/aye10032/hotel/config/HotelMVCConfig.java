package com.aye10032.hotel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: hotel
 * @className: HotelMVCConfig
 * @Description: MVC扩展配置
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/4/22 下午 10:50
 */
@Configuration
public class HotelMVCConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/manager/").setViewName("manager/login");
        registry.addViewController("/manager/login.html").setViewName("manager/login");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/register-1.html").setViewName("register-1");
        registry.addViewController("/register-2.html").setViewName("register-2");
        registry.addViewController("/roomPrice.html").setViewName("roomPrice");

        registry.addViewController("/memberCenter.html").setViewName("/memberCenter");
        registry.addViewController("/subscriptionDetail.html").setViewName("subscriptionDetail");
        registry.addViewController("/historySubscription.html").setViewName("historySubscription");
        registry.addViewController("/editMember.html").setViewName("editMember");
        registry.addViewController("/editSubscription.html").setViewName("editSubscription");
        registry.addViewController("/editPassword.html").setViewName("editPassword");

        registry.addViewController("/createSubscriptionDtl-1.html").setViewName("createSubscriptionDtl-1");
        registry.addViewController("/createSubscriptionDtl-2.html").setViewName("/createSubscriptionDtl-2");
        registry.addViewController("/createSubscriptionDtl-3.html").setViewName("createSubscriptionDtl-3");//静态页面无需controller
        registry.addViewController("/mySubscription.html").setViewName("mySubscription");
        registry.addViewController("/newSubscription.html").setViewName("newSubscription");

        registry.addViewController("/subscriptionView.html").setViewName("subscriptionView");//无该页面
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/index.html", "/register-1.html", "/register", "/register-2.html",
                        "/login.html", "/user_login", "/roomPrice.html",
                        "/images/*", "/js/*", "/style/*", "/manager/", "/manager/login.html");
    }
}
