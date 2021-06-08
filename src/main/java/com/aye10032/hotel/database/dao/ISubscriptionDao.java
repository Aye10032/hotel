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

    @Select("SELECT count(*) FROM sqlite_master WHERE type=\"table\" AND name = \"subscripiton\"")
    Integer SubscriptionTableExist();

    @Update("create table subscriptiondtl\n" +
            "(\n" +
            "    id         INTEGER not null\n" +
            "        constraint subscriptiondtl_pk\n" +
            "            primary key autoincrement,\n" +
            "    rid        INTEGER\n" +
            "        references room,\n" +
            "    sid        INTEGER\n" +
            "        references subscription,\n" +
            "    sdate      BLOB    not null,\n" +
            "    edate      BLOB    not null,\n" +
            "    residetype INTEGER not null,\n" +
            "    price      FLOAT   not null\n" +
            ");")
    void creatSubscriptionTable();

}
