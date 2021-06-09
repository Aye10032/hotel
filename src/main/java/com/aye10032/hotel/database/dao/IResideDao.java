package com.aye10032.hotel.database.dao;

import com.aye10032.hotel.database.pojo.Reside;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @program: hotel
 * @className: IResideDao
 * @Description: reside类DAO接口类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/6/8 下午 2:43
 */
public interface IResideDao {

    @Select("SELECT count(*) FROM sqlite_master WHERE type=\"table\" AND name = \"reside\"")
    Integer ResideTableExist();

    @Update("create table reside\n" +
            "(\n" +
            "    id         INTEGER not null\n" +
            "        constraint reside_pk\n" +
            "            primary key autoincrement,\n" +
            "    dtlid      INTEGER not null\n" +
            "        references subscriptiondtl\n" +
            "            on update cascade on delete cascade,\n" +
            "    residedate BLOB    not null,\n" +
            "    roomername TEXT,\n" +
            "    idcard     TEXT\n" +
            ");")
    void creatResideTable();

    @Insert("INSERT INTO 'reside'"+
            "('dtlid','residedate','roomername','idcard') VALUES "+
            "(#{dtlid},#{residedate},#{roomername},#{idcard});")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    Integer insertResideTable(Reside reside);

    @Update("DELETE FROM 'reside'" +
            "WHERE ID =#{id}")
    void dropResideTable(Integer id);

    @Update("UPDATE 'reside' SET" +
            "dtlid=#{dtlid},residedate=#{residedate},roomername=#{roomername},idcard=#{idcard}" +
            "WHERE id=#{id};")
    void updateResideTable(Reside reside);

    @Select("SELECT * FROM 'reside' WHERE id=#{id}")
    List<Reside> selectResideTable(Integer id);

}
