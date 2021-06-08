package com.aye10032.hotel.database.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: hotel
 * @className: ManagerDaompl
 * @Description: manage接口实现
 * @version: v1.0
 * @author: DoubleZhuang
 * @date: 2021/6/8 16:14
 */
public class ManagerDaompl implements IManagerDao{

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
    public Integer ManagerTableExist() {
        Integer result = null;
        initSession();

        IManagerDao dao = session.getMapper(IManagerDao.class);
        result = dao.ManagerTableExist();

        closeAll();
        return result;
    }

    @Override
    public void creatManagerTable() {
        initSession();

        IManagerDao dao = session.getMapper(IManagerDao.class);
        dao.creatManagerTable();

        session.commit();
        closeAll();
    }
}