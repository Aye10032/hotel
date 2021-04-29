package com.aye10032.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: hotel
 * @className: MemberCenterController
 * @Description: 会员中心controller界面
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/4/23 上午 10:13
 */
@Controller
public class MemberCenterController {

    @RequestMapping("/memberCenter")
    public String memberCenter(){
        return "memberCenter";
    }
}
