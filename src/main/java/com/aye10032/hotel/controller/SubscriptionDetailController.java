package com.aye10032.hotel.controller;

import com.aye10032.hotel.database.dao.SubscriptionDaompl;
import com.aye10032.hotel.database.dao.SubscriptiondtlDaompl;
import com.aye10032.hotel.database.pojo.SubdtlTemp;
import com.aye10032.hotel.database.pojo.Subscriptiondtl;
import com.aye10032.hotel.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * @program: hotel
 * @className: SubscriptionDetailController
 * @Description: 订单明细管理页面controller
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/5/10 下午 4:54
 */
@Controller
public class SubscriptionDetailController {

    @RequestMapping("/subscriptionDetail/{sno}")
    public String subscriptionDetail(
            @PathVariable("sno")Integer id
            , Model model, HttpSession session){
        session.setAttribute("subID",id);

        return "redirect:/subscriptionDetail";
    }

    @RequestMapping("/subscriptionDetail")
    public String subscriptionDetail(Model model, HttpSession session){
        SubscriptiondtlDaompl dao = new SubscriptiondtlDaompl();
        Collection<Subscriptiondtl> subscriptiondtls =
                dao.selectSubscriptiondtlBySid(
                        Util.findSubscriptionBySno(session.getAttribute("subID").toString()).getId());

        Collection<SubdtlTemp> subdtlTemps = Util.dtl2temp(subscriptiondtls);

        model.addAttribute("tmps",subdtlTemps);
        return "subscriptionDetail";
    }

    @RequestMapping("/delet_subdtl/{id}")
    public String deleteSubscriptionDetail(@PathVariable("id")Integer id){
        SubscriptiondtlDaompl dao = new SubscriptiondtlDaompl();
        dao.deleteSubscriptiondtl(id);

        return "redirect:/subscriptionDetail";
    }

}
