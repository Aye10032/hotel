package com.aye10032.hotel.util;

import com.aye10032.hotel.database.dao.MemberDaoImpl;
import com.aye10032.hotel.database.dao.SubscriptionDaompl;
import com.aye10032.hotel.database.pojo.Member;
import com.aye10032.hotel.database.pojo.Subscription;

import java.util.Date;
import java.util.List;

/**
 * @program: hotel
 * @className: Util
 * @Description: 工具类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/6/9 下午 5:24
 */
public class Util {

    public static Integer getMemberID(String username) {
        MemberDaoImpl dao = new MemberDaoImpl();

        List<Member> list = dao.FindMember(username);
        if (list.isEmpty()) {
            return -1;
        } else {
            return list.get(0).getId();
        }
    }

    public static Subscription getLastSubscription(){
        SubscriptionDaompl daompl = new SubscriptionDaompl();

        List<Subscription> subscriptions = daompl.getLastSubscriptionTable();
        if (subscriptions.isEmpty()){
            return null;
        }else {
            return subscriptions.get(0);
        }
    }
}
