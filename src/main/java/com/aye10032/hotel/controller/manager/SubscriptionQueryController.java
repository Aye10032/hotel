package com.aye10032.hotel.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: hotel
 * @className: SubscriptionQueryController
 * @Description: 管理员页面controller
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/6/15 下午 5:47
 */
@Controller
public class SubscriptionQueryController {

    @RequestMapping("/manager/subscriptionQuery")
    public String subscriptionQuery(){
        return "/manager/subscriptionQuery";
    }

}
