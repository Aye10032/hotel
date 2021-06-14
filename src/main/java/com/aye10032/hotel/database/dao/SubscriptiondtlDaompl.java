package com.aye10032.hotel.database.dao;

import com.aye10032.hotel.database.pojo.Subscriptiondtl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

/**
 * @program: hotel
 * @className: SubscriptiondtlDaompl
 * @Description: subscriptiondtl
 * @version: v1.0
 * @author: DoubleZhuang
 * @date: 2021/6/8 16:23
 */
public class SubscriptiondtlDaompl implements ISubscriptiondtlDao {

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
    public Integer SubscriptiondtlTableExist() {
        Integer result = null;
        initSession();

        ISubscriptiondtlDao dao = session.getMapper(ISubscriptiondtlDao.class);
        result = dao.SubscriptiondtlTableExist();

        closeAll();
        return result;
    }

    @Override
    public void creatSubscriptiondtlTable() {
        initSession();

        ISubscriptiondtlDao dao = session.getMapper(ISubscriptiondtlDao.class);
        dao.creatSubscriptiondtlTable();

        session.commit();
        closeAll();
    }

    @Override
    public Integer InsertSubscriptiondtl(Subscriptiondtl subscriptiondtl) {
        initSession();

        ISubscriptiondtlDao dao = session.getMapper(ISubscriptiondtlDao.class);
        dao.InsertSubscriptiondtl(subscriptiondtl);

        session.commit();
        closeAll();

        return subscriptiondtl.getId();
    }

    @Override
    public Collection<Subscriptiondtl> selectSubscriptiondtlBySid(Integer sid) {
        Collection<Subscriptiondtl> subscriptiondtls = null;
        initSession();

        ISubscriptiondtlDao dao = session.getMapper(ISubscriptiondtlDao.class);
        subscriptiondtls = dao.selectSubscriptiondtlBySid(sid);

        closeAll();
        return subscriptiondtls;
    }

    @Override
    public void deleteSubscriptiondtl(Integer id) {
        initSession();

        ISubscriptiondtlDao dao = session.getMapper(ISubscriptiondtlDao.class);
        dao.deleteSubscriptiondtl(id);

        session.commit();
        closeAll();
    }
}
