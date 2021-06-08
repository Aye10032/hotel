package com.aye10032.hotel.controller;

import com.aye10032.hotel.database.dao.MemberDaoImpl;
import com.aye10032.hotel.database.pojo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

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
    public String newSubscription(
            @RequestParam("name") String linkman,
            Model model, HttpSession session)
    {
        MemberDaoImpl dao = new MemberDaoImpl();
        Member member = dao.FindMember(session.getAttribute("LoginUser").toString()).get(0);
        model.addAttribute("name", member.getName());

        return "newSubscription";
    }
}
