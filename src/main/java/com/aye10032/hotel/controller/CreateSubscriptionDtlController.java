package com.aye10032.hotel.controller;

import com.aye10032.hotel.database.pojo.Room;
import com.aye10032.hotel.database.pojo.Subscriptiondtl;
import com.aye10032.hotel.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @program: hotel
 * @className: CreateSubscriptionDtl1Controller
 * @Description: 新增预定controller
 * @version: v1.0
 * @author: DoubleZhuang
 * @date: 2021/5/26 17:00
 */
@Controller
public class CreateSubscriptionDtlController {

    @RequestMapping("/createSubscriptionDtl-1")
    public String createSubscriptionDtl1(Model model, HttpSession session){
        return "createSubscriptionDtl-1";
    }

    @RequestMapping("/createSubscriptionDtl-2")
    public String createSubscriptionDtl2(
            @RequestParam("rootType")String rootType,
            @RequestParam("bookType")String bookType,
            @RequestParam("startDate")String startDate,
            @RequestParam("endDate")String endDate,
            Model model, HttpSession session){

        Iterator<Collection<Room>> rooms = Util.selectRoom(rootType);
        model.addAttribute("rooms1",rooms.next());
        model.addAttribute("rooms2",rooms.next());

        return "createSubscriptionDtl-2";
    }

    @RequestMapping("/createSubscriptionDtl-3")
    public String createSubscriptionDtl3(
            @RequestParam("room")String[] rooms
    ){
        System.out.println(Arrays.toString(rooms));
        return "createSubscriptionDtl-3";
    }
}
