package com.aye10032.hotel.controller;

import com.aye10032.hotel.database.dao.SubscriptionDaompl;
import com.aye10032.hotel.database.pojo.Subscription;
import com.aye10032.hotel.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * @program: hotel
 * @className: HistorySubscriptionController
 * @Description: 历史订单界面controller
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/6/14 下午 12:56
 */
@Controller
public class HistorySubscriptionController {

    @RequestMapping("/historySubscription")
    public String historySubscription(Model model, HttpSession session){
        System.out.println("hi");
        SubscriptionDaompl daompl = new SubscriptionDaompl();
        Collection<Subscription> subscriptions = daompl.selectSubscriptionByMid(
                Util.getMemberID(session.getAttribute("LoginUser").toString()));
        model.addAttribute("history_subs",subscriptions);
        return "historySubscription";
    }

}
