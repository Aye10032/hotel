package com.aye10032.hotel.database.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @program: hotel
 * @className: ICategoryDao
 * @Description: category dao接口
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/6/8 下午 2:42
 */
public interface ICategoryDao {

    @Select("SELECT count(*) FROM sqlite_master WHERE type=\"table\" AND name = \"category\"")
    Integer CategoryTableExist();

    @Update("create table category\n" +
            "(\n" +
            "    id          INTEGER not null\n" +
            "        constraint category_pk\n" +
            "            primary key autoincrement,\n" +
            "    name        TEXT    not null,\n" +
            "    code        TEXT    not null,\n" +
            "    description TEXT,\n" +
            "    bedprice    FLOAT   not null,\n" +
            "    roomprice   FLOAT   not null\n" +
            ");")
    void creatCategoryTable();

}
