package com.aye10032.hotel.database.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @program: hotel
 * @className: ISubscriptionDao
 * @Description: subscription类DAO接口
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/6/8 下午 2:45
 */
public interface ISubscriptionDao {

    @Select("SELECT count(*) FROM sqlite_master WHERE type=\"table\" AND name = \"subscription\"")
    Integer SubscriptionTableExist();

    @Update("create table subscription\n" +
            "(\n" +
            "    id      INTEGER not null\n" +
            "        constraint subscription_pk\n" +
            "            primary key autoincrement,\n" +
            "    mid     INTEGER not null\n" +
            "        references member,\n" +
            "    sno     TEXT    not null,\n" +
            "    linkman TEXT    not null,\n" +
            "    email   TEXT    not null,\n" +
            "    phone   TEXT    not null,\n" +
            "    status  TEXT    not null,\n" +
            "    cretime BLOB    not null,\n" +
            "    remark  TEXT\n" +
            ");")
    void creatSubscriptionTable();

}
