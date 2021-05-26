package com.aye10032.hotel.controller;

import com.aye10032.hotel.database.dao.MemberDaoImpl;
import com.aye10032.hotel.database.pojo.Member;
import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;
import jdk.internal.jline.console.completer.StringsCompleter;
import org.graalvm.compiler.lir.amd64.AMD64Move;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.time.format.DecimalStyle;

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
        MemberDaoImpl dao = new MemberDaoImpl();
        Member member = dao.FindMember(session.getAttribute("LoginUser").toString()).get(0);
        System.out.println("hi " + member.getUsername());
        model.addAttribute("name", member.getName());
        model.addAttribute("phone", member.getPhone());
        model.addAttribute("email", member.getEmail());
        return "editMember";
    }

}
