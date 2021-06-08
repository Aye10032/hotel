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

    @Select("SELECT count(*) FROM sqlite_master WHERE type=\"table\" AND name = \"member\"")
    Integer SubscriptionTableExist();

    @Update("")
    void creatSubscriptionTable();

}
