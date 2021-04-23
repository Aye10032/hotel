package com.doublezhuang.hotel.database;

import com.doublezhuang.hotel.database.dao.MemberDaoImpl;

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
        if (!file.exists()){
            MemberDaoImpl dao = new MemberDaoImpl();

            dao.CreatMemberTable();
        }else {
            //TODO
        }
    }

}
