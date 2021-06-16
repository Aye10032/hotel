package com.aye10032.hotel.controller;

import com.aye10032.hotel.database.dao.SubscriptiondtlDaompl;
import com.aye10032.hotel.database.pojo.Room;
import com.aye10032.hotel.database.pojo.Subscription;
import com.aye10032.hotel.database.pojo.Subscriptiondtl;
import com.aye10032.hotel.util.DateUtil;
import com.aye10032.hotel.util.StringMSG;
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
    public String createSubscriptionDtl1(Model model, HttpSession session) {
        return "createSubscriptionDtl-1";
    }

    @RequestMapping("/createSubscriptionDtl-2")
    public String createSubscriptionDtl2(
            @RequestParam("rootType") String rootType,
            @RequestParam("bookType") String bookType,
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate,
            Model model, HttpSession session) {

        Iterator<Collection<Room>> rooms = Util.selectRoom(rootType);
        if (rooms.hasNext())
            model.addAttribute("rooms1", rooms.next());
        if (rooms.hasNext())
            model.addAttribute("rooms2", rooms.next());

        session.setAttribute("rootType", rootType);
        session.setAttribute("bookType", bookType);
        session.setAttribute("startDate", startDate);
        session.setAttribute("endDate", endDate);

        return "createSubscriptionDtl-2";
    }

    @RequestMapping("/createSubscriptionDtl-3")
    public String createSubscriptionDtl3(
            @RequestParam("room") String[] rooms,
            Model model, HttpSession session) {
        String rootType = session.getAttribute("rootType").toString();
        String bookType = session.getAttribute("bookType").toString();
        String startDate = session.getAttribute("startDate").toString();
        String endDate = session.getAttribute("endDate").toString();

        Subscriptiondtl subscription = new Subscriptiondtl();
        subscription.setSdate(DateUtil.Str2Date(startDate));
        subscription.setEdate(DateUtil.Str2Date(endDate));
        subscription.setSid(
                Util.findSubscriptionBySno(
                        session.getAttribute("subID")
                                .toString()).getId());
        subscription.setPrice(Util.getPrice(bookType, rootType));
        subscription.setResidetype(Util.getResideType(bookType).toString());

        SubscriptiondtlDaompl dao = new SubscriptiondtlDaompl();
        for (String room:rooms){
            Integer rid = Util.findRoomByRno(room).getId();
            subscription.setRid(rid);
            dao.InsertSubscriptiondtl(subscription);
            Util.changeRoomStatus(rid, StringMSG.ROOM_CLOSE);
        }
        return "createSubscriptionDtl-3";
    }
}
