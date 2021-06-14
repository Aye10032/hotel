package com.aye10032.hotel.util;

import com.aye10032.hotel.database.dao.CategoryDaoImpl;
import com.aye10032.hotel.database.dao.MemberDaoImpl;
import com.aye10032.hotel.database.dao.RoomDaompl;
import com.aye10032.hotel.database.dao.SubscriptionDaompl;
import com.aye10032.hotel.database.pojo.*;

import java.util.*;

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

    public static Subscription getLastSubscription() {
        SubscriptionDaompl daompl = new SubscriptionDaompl();

        List<Subscription> subscriptions = daompl.getLastSubscriptionTable();
        if (subscriptions.isEmpty()) {
            return null;
        } else {
            return subscriptions.get(0);
        }
    }

    public static Member findMemberByName(String name) {
        MemberDaoImpl dao = new MemberDaoImpl();
        List<Member> members = dao.FindMember(name);

        if (members.isEmpty()) {
            return null;
        } else {
            return members.get(0);
        }
    }

    public static Subscription findSubscriptionBySno(String sno) {
        SubscriptionDaompl dao = new SubscriptionDaompl();
        List<Subscription> subscriptions = dao.selectSubscriptionBySno(sno);

        if (subscriptions.isEmpty()) {
            return null;
        } else {
            return subscriptions.get(0);
        }
    }

    public static void addCategory(String name, String code, Float bedprice, Float roomprice, String desc) {
        Category category = new Category();
        category.setName(name);
        category.setCode(code);
        category.setBedprice(bedprice);
        category.setRoomprice(roomprice);
        category.setDescription(desc);

        CategoryDaoImpl dao = new CategoryDaoImpl();
        dao.insertCategoryTable(category);
    }

    public static void addRoom(Integer cid, String no, String status) {
        Room room = new Room();
        room.setCid(cid);
        room.setRno(no);
        room.setStatus(status);

        RoomDaompl dao = new RoomDaompl();
        dao.insertRoomTable(room);
    }

    public static Iterator<Collection<Room>> selectRoom(String rootType) {
        Room room = new Room();
        room.setStatus(StringMSG.ROOM_OPEN);
        if (rootType.equals("1")) {
            room.setCid(StringMSG.SINGLE_ROOM);
        } else if (rootType.equals("2")) {
            room.setCid(StringMSG.DOUBLE_ROOM);
        } else {
            room.setCid(StringMSG.HUGE_ROOM);
        }

        Collection<Collection<Room>> rooms = new ArrayList<Collection<Room>>();
        RoomDaompl dao = new RoomDaompl();
        Iterator<Room> all_room = dao.selectChooseRoom(room).iterator();

        int flag = 0;
        Collection<Room> rooms_ = new ArrayList<Room>();
        while (all_room.hasNext()) {
            Room r = all_room.next();
            rooms_.add(r);
            flag++;
            if (flag == 6) {
                flag = 0;
                rooms.add(rooms_);
                rooms_ = new ArrayList<>();
            }
        }
        if (flag != 0) {
            rooms.add(rooms_);
        }

        return rooms.iterator();
    }

    public static Integer getResideType(String bookType) {
        if (bookType.equals("1")) {
            return StringMSG.BED_ONLY;
        } else {
            return StringMSG.ALL_ROOM;
        }
    }

    public static Float getPrice(String bookType, String rootType) {
        Category category;

        int id;
        switch (rootType) {
            case "1":
                id = StringMSG.SINGLE_ROOM;
                break;
            case "2":
                id = StringMSG.DOUBLE_ROOM;
                break;
            case "3":
                id = StringMSG.HUGE_ROOM;
                break;
            default:
                id = 1;
                break;
        }

        CategoryDaoImpl dao = new CategoryDaoImpl();
        category = dao.selectCategoryTable(id).get(0);
        Float price;
        switch (bookType) {
            case "1":
                price = category.getBedprice();
                break;
            case "2":
                price = category.getRoomprice();
                break;
            default:
                price = category.getRoomprice();
                break;
        }

        return price;
    }

    public static Room findRoomByRno(String rno) {
        RoomDaompl roomDaompl = new RoomDaompl();

        List<Room> rooms = roomDaompl.selectRoomByRno(rno);

        return rooms.get(0);
    }

    public static SubdtlTemp getSubDtl(Subscriptiondtl subscriptiondtl) {
        SubdtlTemp sub = new SubdtlTemp();

        Room room = new RoomDaompl().selectRoomTable(subscriptiondtl.getRid()).get(0);

        sub.setId(subscriptiondtl.getId());
        sub.setSdate(subscriptiondtl.getSdate());
        sub.setEdate(subscriptiondtl.getEdate());
        sub.setPrice(subscriptiondtl.getPrice());
        sub.setRes_type(subscriptiondtl.getResidetype());
        sub.setRno(room.getRno());

        switch (room.getCid()) {
            case 1:
                sub.setR_type("普通间");
                break;
            case 2:
                sub.setR_type("舒适间");
                break;
            case 3:
                sub.setR_type("豪华间");
                break;
            default:
                sub.setR_type("单人至尊宇宙豪华总统间");
                break;
        }

        return sub;
    }

    public static Collection<SubdtlTemp> dtl2temp(Collection<Subscriptiondtl> subscriptiondtls) {
        Collection<SubdtlTemp> temps = new ArrayList<>();

        for (Subscriptiondtl subscriptiondtl : subscriptiondtls) {
            temps.add(getSubDtl(subscriptiondtl));
        }

        return temps;
    }

    public static void changeRoomStatus(Integer rid, String flag) {
        RoomDaompl dao = new RoomDaompl();

        Room room = new Room();
        room.setId(rid);
        room.setStatus(flag);

        dao.updateRoomStatus(room);
    }
}
