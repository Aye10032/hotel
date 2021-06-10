package com.aye10032.hotel.controller;

import com.aye10032.hotel.database.dao.MemberDaoImpl;
import com.aye10032.hotel.database.pojo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
        System.out.println(id);

        return "editSubscription";
    }

}
