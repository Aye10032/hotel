package com.aye10032.hotel.database;

import com.aye10032.hotel.database.dao.*;

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
        }else {
            if (managerDaompl.ManagerTableExist() == 0){
                managerDaompl.creatManagerTable();
            }
            if (categoryDao.CategoryTableExist() == 0){
                categoryDao.creatCategoryTable();
            }
            if (memberDao.MemberTableExist() == 0){
                memberDao.CreatMemberTable();
            }
            if (roomDaompl.RoomTableExist() == 0){
                roomDaompl.creatRoomTable();
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

}
