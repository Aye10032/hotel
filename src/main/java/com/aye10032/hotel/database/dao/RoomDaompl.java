package com.aye10032.hotel.database.dao;

import com.aye10032.hotel.database.pojo.Room;
import com.sun.tools.javac.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: hotel
 * @className: RoomDaompl
 * @Description: room接口实现
 * @version: v1.0
 * @author: DoubleZhuang
 * @date: 2021/6/8 16:20
 */
public class RoomDaompl implements IRoomDao{

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
        return null;
    }

    @Override
    public void dropRoomTable(Integer id) {

    }

    @Override
    public void updateRoomTable(Room room) {

    }

    @Override
    public List<Room> selectRoomTable(Integer id) {
        return null;
    }
}
