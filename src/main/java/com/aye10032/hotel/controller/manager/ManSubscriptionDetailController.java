package com.aye10032.hotel.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: hotel
 * @className: SubscriptionDetailController
 * @Description: 管理订单界面controller
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/6/16 下午 4:33
 */
@Controller
public class ManSubscriptionDetailController {

    @RequestMapping("/manager/subscriptionDetail")
    public String SubscriptionDetail(){
        return "/manager/subscriptionDetail";
    }

}
