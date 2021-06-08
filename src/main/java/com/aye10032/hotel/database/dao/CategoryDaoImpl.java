package com.aye10032.hotel.database.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: hotel
 * @className: CategoryDaoImpl
 * @Description: category接口实现
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/6/8 下午 4:08
 */
public class CategoryDaoImpl implements ICategoryDao{

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
    public Integer CategoryTableExist() {
        Integer result = null;
        initSession();

        ICategoryDao dao = session.getMapper(ICategoryDao.class);
        result = dao.CategoryTableExist();

        closeAll();
        return result;
    }

    @Override
    public void creatCategoryTable() {
        initSession();

        ICategoryDao dao = session.getMapper(ICategoryDao.class);
        dao.creatCategoryTable();

        session.commit();
        closeAll();
    }
}
