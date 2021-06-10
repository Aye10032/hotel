package com.aye10032.hotel.database.dao;

import com.aye10032.hotel.database.pojo.Subscription;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

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
            "        references member\n" +
            "            on update cascade on delete cascade,\n" +
            "    sno     TEXT    not null,\n" +
            "    linkman TEXT    not null,\n" +
            "    email   TEXT    not null,\n" +
            "    phone   TEXT    not null,\n" +
            "    status  TEXT    not null,\n" +
            "    cretime BLOB    not null,\n" +
            "    remark  TEXT\n" +
            ");")
    void creatSubscriptionTable();

    @Insert("INSERT INTO 'subscription'" +
            "('mid','sno','linkman','email','phone','status','cretime','remark') VALUES" +
            "(#{mid},#{sno},#{linkman},#{email},#{phone},#{status},#{cretime},#{remark});")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    Integer insertSubscriptionTable(Subscription subscription);

    @Update("DELETE FROM 'subscription'" +
            "WHERE ID =#{id}")
    void  dropSubscriptionTable(Integer id);

    @Update("UPDATE 'subscription' SET" +
            "mid=#{mid},sno=#{sno},linkman=#{linkman},email=#{email},phone=#{phone},status=#{status},cretime=#{cretime},remark={remark}" +
            "WHERE id=#{id};")
    void  updateSubscriptionTable(Subscription subscription);

    @Select("SELECT * FROM 'subscription' WHERE id=#{id}")
    List<Subscription> selectSubscriptionTable(Integer id);

    @Select("SELECT MAX(id) FROM 'subscription'")
    List<Subscription> getLastSubscriptionTable();

}
