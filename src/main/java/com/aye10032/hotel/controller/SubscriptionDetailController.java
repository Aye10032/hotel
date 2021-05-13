package com.aye10032.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/subscriptionDetail")
    public String subscriptionDetail(){
        return "subscriptionDetail";
    }

}
