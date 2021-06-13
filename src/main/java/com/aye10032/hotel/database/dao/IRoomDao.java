package com.aye10032.hotel.database.dao;

import com.aye10032.hotel.database.pojo.Room;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Collection;
import java.util.List;

/**
 * @program: hotel
 * @className: IRoomDao
 * @Description: room类DAO接口
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/6/8 下午 2:43
 */
public interface IRoomDao {

    @Select("SELECT count(*) FROM sqlite_master WHERE type=\"table\" AND name = \"room\"")
    Integer RoomTableExist();

    @Update("create table room\n" +
            "(\n" +
            "    id     INTEGER not null\n" +
            "        constraint room_pk\n" +
            "            primary key autoincrement,\n" +
            "    cid    INTEGER not null\n" +
            "        references category\n" +
            "            on update cascade on delete cascade,\n" +
            "    rno    TEXT,\n" +
            "    status TEXT\n" +
            ");\n")
    void creatRoomTable();

    @Insert("INSERT INTO 'room'" +
            "('cid','rno','status') VALUES" +
            "(#{cid},#{rno},#{status});")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    Integer insertRoomTable(Room room);

    @Update("DELETE FROM 'room'")
    void dropAllRoomTable();

    @Update("UPDATE 'room' SET " +
            "cid=#{cid},rno=#{rno},status=#{status}" +
            "WHERE id =#{id};")
    void updateRoomTable(Room room);

    @Select("SELECT * from 'room' WHERE id=#{id}")
    List<Room> selectRoomTable(Integer id);

    @Select("SELECT * from 'room' WHERE rno=#{rno}")
    List<Room> selectRoomByRno(String rno);

    @Select("SELECT * from 'room' WHERE cid=#{cid} AND status=#{status}")
    Collection<Room> selectChooseRoom(Room room);
}
