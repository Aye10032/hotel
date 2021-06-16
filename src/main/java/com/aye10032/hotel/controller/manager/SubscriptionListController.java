package com.aye10032.hotel.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

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
    public String SubscriptionList(
            @RequestParam("rootType")String[] rootType,
            @RequestParam("status")String[] status,
            @RequestParam("startDate")String startDate,
            @RequestParam("endDate")String endDate,
            @RequestParam("no")String no,
            @RequestParam("username")String username,
            Model model, HttpSession session){
        System.out.println(Arrays.toString(rootType));
        System.out.println(Arrays.toString(status));
        System.out.println(startDate);
        return "redirect:/manager/subscriptionList";
    }

}
