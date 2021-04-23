package com.doublezhuang.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: hotel
 * @className: LoginController
 * @Description: 登陆界面controller
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/4/23 上午 9:32
 */
@Controller
public class LoginController {

    @RequestMapping("/user_login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        if (StringUtils.hasLength(username)){
            return "memberCenter";
        }else {
            model.addAttribute("msg", "用户名不能为空！");
            return "login";
        }
    }

}