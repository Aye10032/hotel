package com.doublezhuang.hotel.controller;

import com.doublezhuang.hotel.database.dao.DaoImpl;
import com.doublezhuang.hotel.database.pojo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * @program: hotel
 * @className: RegisterController
 * @Description: 注册界面controller
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/4/23 上午 9:35
 */
@Controller
public class RegisterController {

    @RequestMapping("/register-1")
    public String start_register(){
        return "register-1";
    }

    @RequestMapping("/register")
    public String register(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("repassword") String repassword,
            @RequestParam("name") String name,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email,
            Model model) {
        if (!StringUtils.hasLength(username)){
            model.addAttribute("msg", "用户名不能为空！");
            return "register-1";
        }
        if (!StringUtils.hasLength(password)){
            model.addAttribute("msg", "密码不能为空！");
            return "register-1";
        }
        if (!StringUtils.hasLength(repassword)){
            model.addAttribute("msg", "请再次输入密码！");
            return "register-1";
        }
        if (!repassword.equals(password)){
            model.addAttribute("msg", "密码不一致！");
            return "register-1";
        }
        Date date = new Date();
        Member member = new Member();
        member.setUsername(username);
        member.setPwd(password);
        member.setName(name);
        member.setEmail(email);
        member.setPhone(phone);
        member.setRegtime(date);

        DaoImpl dao = new DaoImpl();
        List<Member> members = dao.FindMember(username);
        if (!members.isEmpty()){
            model.addAttribute("msg", "用户名已存在！");
            return "register-1";
        }

        Integer id = dao.InsertMember(member);
        return "redirect:/register-2.html";
    }

    @RequestMapping("/register-2")
    public String register_success(){
        return "register-2";
    }

}
