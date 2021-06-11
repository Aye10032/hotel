package com.aye10032.hotel.database;

import com.aye10032.hotel.database.dao.*;
import com.aye10032.hotel.database.pojo.Category;
import com.aye10032.hotel.database.pojo.Room;
import com.aye10032.hotel.util.StringMSG;
import com.aye10032.hotel.util.Util;

import java.io.File;

/**
 * @program: hotel
 * @className: DataInti
 * @Description: init database
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/4/23 上午 11:43
 */
public class DataInit {

    public static void init(){
        File file = new File("hotel.db");
        CategoryDaoImpl categoryDao = new CategoryDaoImpl();
        ManagerDaompl managerDaompl = new ManagerDaompl();
        MemberDaoImpl memberDao = new MemberDaoImpl();
        ResideDaompl resideDaompl = new ResideDaompl();
        RoomDaompl roomDaompl = new RoomDaompl();
        SubscriptionDaompl subscriptionDaompl = new SubscriptionDaompl();
        SubscriptiondtlDaompl subscriptiondtlDaompl = new SubscriptiondtlDaompl();

        if (!file.exists()){
            managerDaompl.creatManagerTable();

            categoryDao.creatCategoryTable();
            memberDao.CreatMemberTable();
            roomDaompl.creatRoomTable();

            subscriptionDaompl.creatSubscriptionTable();

            subscriptiondtlDaompl.creatSubscriptiondtlTable();
            resideDaompl.creatResideTable();

            initCategory();
            initRoom();
        }else {
            if (managerDaompl.ManagerTableExist() == 0){
                managerDaompl.creatManagerTable();
            }
            if (categoryDao.CategoryTableExist() == 0){
                categoryDao.creatCategoryTable();
                initCategory();
            }
            if (memberDao.MemberTableExist() == 0){
                memberDao.CreatMemberTable();
            }
            if (roomDaompl.RoomTableExist() == 0){
                roomDaompl.creatRoomTable();
                initRoom();
            }
            if (subscriptionDaompl.SubscriptionTableExist() == 0){
                subscriptionDaompl.creatSubscriptionTable();
            }
            if (subscriptiondtlDaompl.SubscriptiondtlTableExist() == 0){
                subscriptiondtlDaompl.creatSubscriptiondtlTable();
            }
            if (resideDaompl.ResideTableExist() == 0){
                resideDaompl.creatResideTable();
            }
        }
    }

    public static void  initCategory(){
        ICategoryDao dao = new CategoryDaoImpl();
        dao.dropCategoryTable();

        Util.addCategory("普通双人间", "rcat01", 50.0F, 80.0F,
                "房间面积：20平米。配有单人床两个、市话、长途服务、独立卫生间、淋浴、24小时热水、电视、空调。");
        Util.addCategory("舒适双人间", "rcat02", 100.0F, 160.0F,
                "房间面积：30平米。配有双人人床一个、市话、长途服务、独立卫生间、淋浴、24小时热水、电视、空调。");
        Util.addCategory("豪华双人间", "rcat03", 150.0F, 260.0F,
                "房间面积：40平米。配有单人床两个、市话、长途服务、独立卫生间、淋浴、24小时热水、电视、空调。");
    }

    public static void initRoom(){
        RoomDaompl roomDaompl = new RoomDaompl();
        roomDaompl.dropAllRoomTable();

        Util.addRoom(1, "101", StringMSG.ROOM_OPEN);
        Util.addRoom(1, "102", StringMSG.ROOM_OPEN);
        Util.addRoom(1, "103", StringMSG.ROOM_OPEN);
        Util.addRoom(1, "104", StringMSG.ROOM_OPEN);
        Util.addRoom(1, "105", StringMSG.ROOM_OPEN);
        Util.addRoom(1, "106", StringMSG.ROOM_OPEN);
        Util.addRoom(1, "107", StringMSG.ROOM_OPEN);
        Util.addRoom(1, "108", StringMSG.ROOM_OPEN);
        Util.addRoom(1, "109", StringMSG.ROOM_OPEN);

        Util.addRoom(2, "201", StringMSG.ROOM_OPEN);
        Util.addRoom(2, "202", StringMSG.ROOM_OPEN);
        Util.addRoom(2, "203", StringMSG.ROOM_OPEN);
        Util.addRoom(2, "204", StringMSG.ROOM_OPEN);
        Util.addRoom(2, "205", StringMSG.ROOM_OPEN);
        Util.addRoom(2, "206", StringMSG.ROOM_OPEN);
        Util.addRoom(2, "207", StringMSG.ROOM_OPEN);
        Util.addRoom(2, "208", StringMSG.ROOM_OPEN);
        Util.addRoom(2, "209", StringMSG.ROOM_OPEN);

        Util.addRoom(3, "301", StringMSG.ROOM_OPEN);
        Util.addRoom(3, "302", StringMSG.ROOM_OPEN);
        Util.addRoom(3, "303", StringMSG.ROOM_OPEN);
        Util.addRoom(3, "304", StringMSG.ROOM_OPEN);
        Util.addRoom(3, "305", StringMSG.ROOM_OPEN);
        Util.addRoom(3, "306", StringMSG.ROOM_OPEN);
        Util.addRoom(3, "307", StringMSG.ROOM_OPEN);
        Util.addRoom(3, "308", StringMSG.ROOM_OPEN);
        Util.addRoom(3, "309", StringMSG.ROOM_OPEN);
    }

}
