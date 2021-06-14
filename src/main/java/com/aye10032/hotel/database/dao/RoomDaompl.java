package com.aye10032.hotel.database.dao;

import com.aye10032.hotel.database.pojo.Room;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

/**
 * @program: hotel
 * @className: RoomDaompl
 * @Description: room接口实现
 * @version: v1.0
 * @author: DoubleZhuang
 * @date: 2021/6/8 16:20
 */
public class RoomDaompl implements IRoomDao {

    private InputStream in;
    private SqlSession session;


    private void initSession() {
        try {
            in = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            session = factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeAll() {
        try {
            session.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer RoomTableExist() {
        Integer result = null;
        initSession();

        IRoomDao dao = session.getMapper(IRoomDao.class);
        result = dao.RoomTableExist();

        closeAll();
        return result;
    }

    @Override
    public void creatRoomTable() {
        initSession();

        IRoomDao dao = session.getMapper(IRoomDao.class);
        dao.creatRoomTable();

        session.commit();
        closeAll();
    }

    @Override
    public Integer insertRoomTable(Room room) {
        initSession();

        IRoomDao dao = session.getMapper(IRoomDao.class);
        dao.insertRoomTable(room);

        session.commit();
        closeAll();
        return room.getId();
    }

    @Override
    public void dropAllRoomTable() {
        initSession();

        IRoomDao dao = session.getMapper(IRoomDao.class);
        dao.dropAllRoomTable();

        session.commit();
        closeAll();
    }

    @Override
    public void updateRoomTable(Room room) {
        initSession();

        IRoomDao dao = session.getMapper(IRoomDao.class);
        dao.updateRoomTable(room);

        session.commit();
        closeAll();
    }

    @Override
    public List<Room> selectRoomTable(Integer id) {
        List<Room> rooms = null;
        initSession();

        IRoomDao dao = session.getMapper(IRoomDao.class);
        rooms = dao.selectRoomTable(id);

        closeAll();
        return rooms;
    }

    @Override
    public List<Room> selectRoomByRno(String rno) {
        List<Room> rooms = null;
        initSession();

        IRoomDao dao = session.getMapper(IRoomDao.class);
        rooms = dao.selectRoomByRno(rno);

        closeAll();
        return rooms;
    }

    @Override
    public Collection<Room> selectChooseRoom(Room room) {
        Collection<Room> rooms = null;
        initSession();

        IRoomDao dao = session.getMapper(IRoomDao.class);
        rooms = dao.selectChooseRoom(room);

        closeAll();
        return rooms;
    }

    @Override
    public void updateRoomStatus(Room room) {
        initSession();

        IRoomDao dao = session.getMapper(IRoomDao.class);
        dao.updateRoomStatus(room);

        session.commit();
        closeAll();
    }
}
