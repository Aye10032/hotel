package com.aye10032.hotel.database.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @program: hotel
 * @className: IManagerDao
 * @Description: manager类DAO接口
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/6/8 下午 2:42
 */
public interface IManagerDao {

    @Select("SELECT count(*) FROM sqlite_master WHERE type=\"table\" AND name = \"manager\"")
    Integer ManagerTableExist();

    @Update("create table manager\n" +
            "(\n" +
            "    id       INTEGER not null\n" +
            "        constraint manager_pk\n" +
            "            primary key autoincrement,\n" +
            "    username TEXT    not null,\n" +
            "    pwd      TEXT    not null\n" +
            ");")
    void creatManagerTable();

}
