package com.aye10032.hotel.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: hotel
 * @className: SubscriptionListController
 * @Description: 管理员订单列表controller
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/6/16 下午 4:38
 */
@Controller
public class SubscriptionListController {

    @RequestMapping("/manager/subscriptionList")
    public String SubscriptionList(){
        return "/manager/subscriptionList";
    }

}
