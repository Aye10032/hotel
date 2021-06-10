package com.aye10032.hotel.controller;

import com.aye10032.hotel.database.dao.MemberDaoImpl;
import com.aye10032.hotel.database.dao.SubscriptionDaompl;
import com.aye10032.hotel.database.pojo.Member;
import com.aye10032.hotel.database.pojo.Subscription;
import com.aye10032.hotel.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @program: hotel
 * @className: EditSubscriptionController
 * @Description:
 * @version: v1.0
 * @author: DoubleZhuang
 * @date: 2021/5/14 11:21
 */
@Controller
public class EditSubscriptionController {

    @RequestMapping("/editSubscription/{id}")
    public String editSubscription(
            @PathVariable("id")Integer id
            ,Model model, HttpSession session){
        session.setAttribute("subID",id);

        return "redirect:/editSubscription";
    }

    @RequestMapping("/editSubscription")
    public String editSubscription(
            Model model, HttpSession session){

        Subscription subscription = Util.findSubscriptionBySno(
                session.getAttribute("subID").toString());
        model.addAttribute("name",subscription.getLinkman());
        model.addAttribute("phone",subscription.getPhone());
        model.addAttribute("email",subscription.getEmail());
        return "editSubscription";
    }

    @RequestMapping("/save_subscription")
    public String saveSubscription(
            @RequestParam("name") String name,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email,
            Model model, HttpSession session){

        Subscription subscription = Util.findSubscriptionBySno(
                session.getAttribute("subID").toString());
        if (subscription!=null) {
            subscription.setLinkman(name);
            subscription.setPhone(phone);
            subscription.setEmail(email);

            System.out.println(subscription);

            SubscriptionDaompl dao = new SubscriptionDaompl();
            dao.updateSubscriptionTable(subscription);
        }

        return "redirect:/memberCenter";
    }

}
