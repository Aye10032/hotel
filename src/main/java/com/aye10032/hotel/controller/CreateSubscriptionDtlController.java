package com.aye10032.hotel.controller;

import com.aye10032.hotel.database.pojo.Subscriptiondtl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
public class CreateSubscriptionDtlController {

    @RequestMapping("/createSubscriptionDtl-1")
    public String createSubscriptionDtl1(Model model, HttpSession session){
        return "createSubscriptionDtl-1";
    }

    @RequestMapping("/createSubscriptionDtl-2")
    public String createSubscriptionDtl2(
            @RequestParam("rootType")String rootType,
            @RequestParam("bookType")String bookType,
            @RequestParam("startDate")String startDate,
            @RequestParam("endDate")String endDate,
            Model model, HttpSession session){
        System.out.println(rootType);
        System.out.println(bookType);
        System.out.println(startDate);
        System.out.println(endDate);
        return "createSubscriptionDtl-2";
    }
}
