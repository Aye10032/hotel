package com.aye10032.hotel.controller;

import com.aye10032.hotel.database.dao.SubscriptionDaompl;
import com.aye10032.hotel.database.pojo.Subscription;
import com.aye10032.hotel.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * @program: hotel
 * @className: MemberCenterController
 * @Description: 会员中心controller界面
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/4/23 上午 10:13
 */
@Controller
public class MemberCenterController {

    @RequestMapping("/memberCenter")
    public String memberCenter(Model model, HttpSession session){
        SubscriptionDaompl daompl = new SubscriptionDaompl();
        Collection<Subscription> subscriptions = daompl.selectSubscriptionByMid(
                Util.getMemberID(session.getAttribute("LoginUser").toString()));
        System.out.println(subscriptions);
        model.addAttribute("subs",subscriptions);
        return "memberCenter";
    }
}
