package com.doublezhuang.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: hotel
 * @className: RegisterController
 * @Description: 注册界面controller
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/4/23 上午 9:35
 */
@Controller
public class RegisterController {

    @RequestMapping("/register-1")
    public String register(){
        return "register-1";
    }

}
