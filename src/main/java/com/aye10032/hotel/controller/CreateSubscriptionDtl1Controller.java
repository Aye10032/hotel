package com.aye10032.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @program: hotel
 * @className: CreateSubscriptionDtl1Controller
 * @Description: 新增预定controller
 * @version: v1.0
 * @author: DoubleZhuang
 * @date: 2021/5/26 17:00
 */
@Controller
public class CreateSubscriptionDtl1Controller {

    @RequestMapping("/createSubscriptionDtl-1")
    public String createSubscriptionDtl1(Model model, HttpSession session){
        System.out.println("in");
        return "createSubscriptionDtl-1";
    }
}
