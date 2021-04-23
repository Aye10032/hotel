package com.doublezhuang.hotel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
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
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/register-1.html").setViewName("register-1");
        registry.addViewController("/memberCenter.html").setViewName("memberCenter");
        registry.addViewController("/register-2.html").setViewName("register-2");
    }
}
