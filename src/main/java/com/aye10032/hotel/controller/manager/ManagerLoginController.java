package com.aye10032.hotel.controller.manager;

import com.aye10032.hotel.database.dao.ManagerDaompl;
import com.aye10032.hotel.database.pojo.Manager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: hotel
 * @className: LoginController
 * @Description: 管理员登陆界面controller
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/6/14 下午 1:54
 */
@Controller
public class ManagerLoginController {

    @RequestMapping("/manager/login")
    public String login() {
        System.out.println("welcome, manager");
        return "/manager/login";
    }

    @RequestMapping("/manager/manager_login")
    public String manager_login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model, HttpSession session) {
        ManagerDaompl dao = new ManagerDaompl();
        List<Manager> managers = dao.selectManagerTable(username);
        if (managers.isEmpty()){
            model.addAttribute("msg", "管理员账户不存在！");
            return "/manager/login";
        }else {
            if (!managers.get(0).getPwd().equals(password)){
                model.addAttribute("msg", "管理员密码错误！");
                return "/manager/login";
            }
        }

        session.setAttribute("manager_name",username);
        return "redirect:/manager/subscriptionQuery";
    }

}
