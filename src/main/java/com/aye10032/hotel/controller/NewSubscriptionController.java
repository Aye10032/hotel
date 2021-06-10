package com.aye10032.hotel.controller;

import com.aye10032.hotel.database.dao.MemberDaoImpl;
import com.aye10032.hotel.database.dao.SubscriptionDaompl;
import com.aye10032.hotel.database.pojo.Member;
import com.aye10032.hotel.database.pojo.Subscription;
import com.aye10032.hotel.util.DateUtil;
import com.aye10032.hotel.util.StringMSG;
import com.aye10032.hotel.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.Collection;
import java.util.List;

/**
 * @program: hotel
 * @className: NewSubscriptionController
 * @Description: 新建订单controller
 * @version: v1.0
 * @author: DoubleZhuang
 * @date: 2021/5/28 11:33
 */
@Controller
public class NewSubscriptionController {
    @RequestMapping("/newSubscription")
    public String newSubscription()
    {
        return "newSubscription";
    }

    @RequestMapping("/newsubscription_action")
    public String newSubscription_action(
            @RequestParam("name") String name,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email,
            Model model, HttpSession session){
        SubscriptionDaompl dao = new SubscriptionDaompl();

        Subscription subscription = new Subscription();
        subscription.setMid(Util.getMemberID(session.getAttribute("LoginUser").toString()));
        subscription.setSno(DateUtil.getSUB_NO());
        subscription.setLinkman(name);
        subscription.setPhone(phone);
        subscription.setEmail(email);
        subscription.setStatus(StringMSG.STATUS_WAIT);
        subscription.setCretime(DateUtil.getNowTime());
        subscription.setRemark("");
        dao.insertSubscriptionTable(subscription);
//        Member member = dao.FindMember(session.getAttribute("LoginUser").toString()).get(0);
        return "memberCenter";
    }
}
