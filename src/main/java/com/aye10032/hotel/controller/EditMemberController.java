package com.aye10032.hotel.controller;

import com.aye10032.hotel.database.dao.MemberDaoImpl;
import com.aye10032.hotel.database.pojo.Member;
import com.aye10032.hotel.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @program: hotel
 * @className: EditMemberController
 * @Description: 修改个人信息界面controller
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/4/23 下午 3:53
 */
@Controller
public class EditMemberController {

    @RequestMapping("/editMember")
    public String editMember(Model model, HttpSession session){
        Member member = Util.findMemberByName(session.getAttribute("LoginUser").toString());

        if (member != null) {
            System.out.println("hi " + member.getUsername());
            model.addAttribute("name", member.getName());
            model.addAttribute("phone", member.getPhone());
            model.addAttribute("email", member.getEmail());
        }
        return "editMember";
    }

    @RequestMapping("/save_member")
    public String saveEdit(
            @RequestParam("name") String name,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email,
            Model model, HttpSession session){
        Member member = Util.findMemberByName(session.getAttribute("LoginUser").toString());

        if (member != null) {
            member.setName(name);
            member.setPhone(phone);
            member.setEmail(email);

            MemberDaoImpl dao = new MemberDaoImpl();
            dao.UpdateMember(member);
        }

        session.removeAttribute("LoginUser");

        return "redirect:/register-2.html";
    }

}
