package com.aye10032.hotel.controller;

import com.aye10032.hotel.database.dao.MemberDaoImpl;
import com.aye10032.hotel.database.pojo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @program: hotel
 * @className: EditPasswordController
 * @Description:修改密码页面controller
 * @version: v1.0
 * @author: DoubleZhuang
 * @date: 2021/5/26 16:43
 */

@Controller
public class EditPasswordController {

    @RequestMapping("/editPassword")
    public String editPassword(Model model, HttpSession session){
        System.out.println("in");
        return "editPassword";
    }
}
