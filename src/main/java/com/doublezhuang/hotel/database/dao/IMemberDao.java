package com.doublezhuang.hotel.database.dao;

import com.doublezhuang.hotel.database.pojo.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

/**
 * @program: hotel
 * @className: IMemberDao
 * @Description: 会员dao接口
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/4/23 上午 11:04
 */
public interface IMemberDao {

    @Update("create table member\n" +
            "(\n" +
            "    id       INTEGER not null\n" +
            "        constraint member_pk\n" +
            "            primary key autoincrement,\n" +
            "    username TEXT    not null,\n" +
            "    pwd      TEXT    not null,\n" +
            "    name     TEXT,\n" +
            "    email    TEXT,\n" +
            "    phone    TEXT,\n" +
            "    regtime  TEXT    not null\n" +
            ");")
    void CreatMemberTable();

    @Insert("INSERT INTO 'member'" +
            "('username','pwd','name','email','phone','regtime') VALUES " +
            "(#{username}, #{pwd}, #{name}, #{email}, #{phone}, #{regtime});")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer InsertMember(Member member);

}
