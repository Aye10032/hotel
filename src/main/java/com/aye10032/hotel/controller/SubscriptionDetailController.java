package com.aye10032.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @program: hotel
 * @className: SubscriptionDetailController
 * @Description: 订单明细管理页面controller
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/5/10 下午 4:54
 */
@Controller
public class SubscriptionDetailController {

    @RequestMapping("/subscriptionDetail/{sno}")
    public String subscriptionDetail(
            @PathVariable("sno")Integer id
            , Model model, HttpSession session){
        session.setAttribute("subID",id);

        return "redirect:/subscriptionDetail";
    }

    @RequestMapping("/subscriptionDetail")
    public String subscriptionDetail(){
        return "subscriptionDetail";
    }

}
