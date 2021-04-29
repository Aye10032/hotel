package com.aye10032.hotel.database;

import com.aye10032.hotel.database.dao.MemberDaoImpl;

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
        MemberDaoImpl dao = new MemberDaoImpl();
        if (!file.exists()){
            dao.CreatMemberTable();
        }else {
            if (dao.TableExist() == 0){
                dao.CreatMemberTable();
            }
        }
    }

}
