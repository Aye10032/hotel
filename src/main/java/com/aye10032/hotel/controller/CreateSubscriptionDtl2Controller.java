package com.aye10032.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @program: hotel
 * @className: CreateSubscriptionDtl2Controller
 * @Description: 预定选择房间号controller
 * @version: v1.0
 * @author: DoubleZhuang
 * @date: 2021/5/28 10:52
 */
@Controller
public class CreateSubscriptionDtl2Controller {
    @RequestMapping("/createSubscriptionDtl-2")
    public String createSubscriptionDtl2(Model model, HttpSession session)
    {
        System.out.println("dt2 in");
        return "createSubscriptionDtl-2";
    }
}
