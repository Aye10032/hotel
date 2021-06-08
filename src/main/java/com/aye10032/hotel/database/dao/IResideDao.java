package com.aye10032.hotel.database.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @program: hotel
 * @className: IResideDao
 * @Description: reside类DAO接口类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/6/8 下午 2:43
 */
public interface IResideDao {

    @Select("SELECT count(*) FROM sqlite_master WHERE type=\"table\" AND name = \"member\"")
    Integer ResideTableExist();

    @Update("")
    void creatResideTable();

}
