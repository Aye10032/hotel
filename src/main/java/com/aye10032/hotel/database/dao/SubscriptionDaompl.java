package com.aye10032.hotel.database.dao;

import com.aye10032.hotel.database.pojo.Subscription;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: hotel
 * @className: SubscriptionDaompl
 * @Description: subscription接口实现
 * @version: v1.0
 * @author: DoubleZhuang
 * @date: 2021/6/8 16:21
 */
public class SubscriptionDaompl implements ISubscriptionDao {

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
    public Integer SubscriptionTableExist() {
        Integer result = null;
        initSession();

        ISubscriptionDao dao = session.getMapper(ISubscriptionDao.class);
        result = dao.SubscriptionTableExist();

        closeAll();
        return result;
    }

    @Override
    public void creatSubscriptionTable() {
        initSession();

        ISubscriptionDao dao = session.getMapper(ISubscriptionDao.class);
        dao.creatSubscriptionTable();

        session.commit();
        closeAll();
    }

    @Override
    public Integer insertSubscriptionTable(Subscription subscription) {
        initSession();

        ISubscriptionDao dao = session.getMapper(ISubscriptionDao.class);
        dao.insertSubscriptionTable(subscription);

        session.commit();
        closeAll();
        return subscription.getId();
    }

    @Override
    public void dropSubscriptionTable(Integer id) {
        initSession();

        ISubscriptionDao dao = session.getMapper(ISubscriptionDao.class);
        dao.dropSubscriptionTable(id);

        session.commit();
        closeAll();
    }

    @Override
    public void updateSubscriptionTable(Subscription subscription) {
        initSession();

        ISubscriptionDao dao = session.getMapper(ISubscriptionDao.class);
        dao.updateSubscriptionTable(subscription);

        session.commit();
        closeAll();
    }

    @Override
    public List<Subscription> selectSubscriptionTable(Integer id) {
        List<Subscription> subscriptions = null;
        initSession();

        ISubscriptionDao dao = session.getMapper(ISubscriptionDao.class);
        subscriptions = dao.selectSubscriptionTable(id);

        closeAll();
        return subscriptions;
    }

    @Override
    public List<Subscription> getLastSubscriptionTable() {
        List<Subscription> subscriptions = null;
        initSession();

        ISubscriptionDao dao = session.getMapper(ISubscriptionDao.class);
        subscriptions = dao.getLastSubscriptionTable();

        closeAll();
        return subscriptions;
    }
}
