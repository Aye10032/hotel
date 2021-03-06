package com.aye10032.hotel.controller;

import com.aye10032.hotel.database.dao.MemberDaoImpl;
import com.aye10032.hotel.database.pojo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: hotel
 * @className: LoginController
 * @Description: 登陆界面controller
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/4/23 上午 9:32
 */
@Controller
public class LoginController {

    @RequestMapping("/user_login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model, HttpSession session) {
        if (!StringUtils.hasLength(username)){
            model.addAttribute("msg", "用户名不能为空！");
            return "login";
        }
        MemberDaoImpl dao = new MemberDaoImpl();
        List<Member> finders = dao.FindMember(username);
        if (finders.isEmpty()){
            model.addAttribute("msg", "用户不存在！");
            return "login";
        }
        Member member = finders.get(0);

        if (!member.getPwd().equals(password)){
            model.addAttribute("msg", "密码错误！");
            return "login";
        }
        session.setAttribute("LoginUser", username);
        return "redirect:/memberCenter";
    }

}
