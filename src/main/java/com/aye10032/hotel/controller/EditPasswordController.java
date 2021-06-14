package com.aye10032.hotel.controller;

import com.aye10032.hotel.database.dao.MemberDaoImpl;
import com.aye10032.hotel.database.pojo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String editPWD(){
        return "editPassword";
    }

    @RequestMapping("/edit_password")
    public String editPassword(
            @RequestParam("password") String password,
            @RequestParam("newPassword") String newPassword,
            @RequestParam("reNewPassword") String reNewPassword,
            Model model, HttpSession session) {
        MemberDaoImpl dao = new MemberDaoImpl();
        Member member = dao.FindMember(session.getAttribute("LoginUser").toString()).get(0);

        if (password.equals(member.getPwd())){
            if (newPassword.equals(reNewPassword)){
                member.setPwd(newPassword);
                dao.UpdateMember(member);
            }else {
                model.addAttribute("msg","新密码不一致！");
                return "editPassword";
            }
        }else {
            model.addAttribute("msg","密码不正确！");
            return "editPassword";
        }
        return "redirect:/register-2.html";
    }
}
