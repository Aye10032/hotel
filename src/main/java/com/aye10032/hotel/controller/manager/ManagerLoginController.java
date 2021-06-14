package com.aye10032.hotel.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: hotel
 * @className: LoginController
 * @Description: 管理员登陆界面controller
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/6/14 下午 1:54
 */
@Controller
public class ManagerLoginController {

    @RequestMapping("/manager/login")
    public String login(){
        System.out.println("welcome, manager");
        return "/manager/login";
    }

    @RequestMapping("/manager/manager_login")
    public String manager_login(){
        return "/manager/subscriptionQuery";
    }

}
