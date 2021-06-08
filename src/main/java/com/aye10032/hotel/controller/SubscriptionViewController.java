package com.aye10032.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @program: hotel
 * @className: SubscriptionViewController
 * @Description: 订单详情controller
 * @version: v1.0
 * @author: DoubleZhuang
 * @date: 2021/5/27 17:10
 */
@Controller
public class SubscriptionViewController {

    @RequestMapping("/subscriptionView")
    public String subscriptionView(Model model, HttpSession session){
        System.out.println("in");
        return "subscriptionView";
    }
}
