package com.aye10032.hotel.database.dao;

import com.aye10032.hotel.database.pojo.Subscriptiondtl;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Collection;

/**
 * @program: hotel
 * @className: IsubscriptiondtlDao
 * @Description: subscriptiondtl类DAO接口
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/6/8 下午 2:45
 */
public interface ISubscriptiondtlDao {

    @Select("SELECT count(*) FROM sqlite_master WHERE type=\"table\" AND name = \"subscriptiondtl\"")
    Integer SubscriptiondtlTableExist();

    @Update("create table subscriptiondtl\n" +
            "(\n" +
            "    id         INTEGER not null\n" +
            "        constraint subscriptiondtl_pk\n" +
            "            primary key autoincrement,\n" +
            "    rid        INTEGER\n" +
            "        references room\n" +
            "            on update cascade on delete cascade,\n" +
            "    sid        INTEGER\n" +
            "        references subscription\n" +
            "            on update cascade on delete cascade,\n" +
            "    sdate      BLOB    not null,\n" +
            "    edate      BLOB    not null,\n" +
            "    residetype INTEGER not null,\n" +
            "    price      FLOAT   not null\n" +
            ");")
    void creatSubscriptiondtlTable();

    @Insert("INSERT INTO 'subscriptiondtl' " +
            "('rid','sid','sdate','edate','residetype','price') VALUES" +
            "(#{rid},#{sid},#{sdate},#{edate},#{residetype},#{price});")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    Integer InsertSubscriptiondtl(Subscriptiondtl subscriptiondtl);

    @Select("SELECT * FROM 'subscriptiondtl' WHERE sid=#{sid}")
    Collection<Subscriptiondtl> selectSubscriptiondtlBySid(Integer sid);
}
