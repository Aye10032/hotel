package com.aye10032.hotel.util;

import com.aye10032.hotel.database.dao.CategoryDaoImpl;
import com.aye10032.hotel.database.dao.MemberDaoImpl;
import com.aye10032.hotel.database.dao.RoomDaompl;
import com.aye10032.hotel.database.dao.SubscriptionDaompl;
import com.aye10032.hotel.database.pojo.Category;
import com.aye10032.hotel.database.pojo.Member;
import com.aye10032.hotel.database.pojo.Room;
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

    public static Member findMemberByName(String name){
        MemberDaoImpl dao = new MemberDaoImpl();
        List<Member> members = dao.FindMember(name);

        if (members.isEmpty()){
            return null;
        }else {
            return members.get(0);
        }
    }

    public static Subscription findSubscriptionBySno(String sno){
        SubscriptionDaompl dao = new SubscriptionDaompl();
        List<Subscription> subscriptions = dao.selectSubscriptionBySno(sno);

        if (subscriptions.isEmpty()){
            return null;
        }else {
            return subscriptions.get(0);
        }
    }

    public static void addCategory(String name, String code, Float bedprice, Float roomprice, String desc){
        Category category = new Category();
        category.setName(name);
        category.setCode(code);
        category.setBedprice(bedprice);
        category.setRoomprice(roomprice);
        category.setDescription(desc);

        CategoryDaoImpl dao = new CategoryDaoImpl();
        dao.insertCategoryTable(category);
    }

    public static void addRoom(Integer cid, String no, String status){
        Room room = new Room();
        room.setCid(cid);
        room.setRno(no);
        room.setStatus(status);

        RoomDaompl dao = new RoomDaompl();
        dao.insertRoomTable(room);
    }
}
