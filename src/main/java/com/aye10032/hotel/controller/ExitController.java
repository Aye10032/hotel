package com.aye10032.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @program: hotel
 * @className: ExitController
 * @Description: 退出登录接口
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/6/8 下午 5:20
 */

@Controller
public class ExitController {

    @RequestMapping("/exit_page")
    public String exit(HttpSession session){
        session.removeAttribute("LoginUser");

        return "redirect:/index.html";
    }

}
