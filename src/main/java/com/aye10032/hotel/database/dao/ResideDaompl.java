package com.aye10032.hotel.database.dao;

import com.aye10032.hotel.database.pojo.Reside;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: hotel
 * @className: ResideDaompl
 * @Description: reside接口实现
 * @version: v1.0
 * @author: DoubleZhuang
 * @date: 2021/6/8 16:18
 */
public class ResideDaompl implements IResideDao {

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
    public Integer ResideTableExist() {
        Integer result = null;
        initSession();

        IResideDao dao = session.getMapper(IResideDao.class);
        result = dao.ResideTableExist();

        closeAll();
        return result;
    }

    @Override
    public void creatResideTable() {
        initSession();

        IResideDao dao = session.getMapper(IResideDao.class);
        dao.creatResideTable();

        session.commit();
        closeAll();
    }

    @Override
    public Integer insertResideTable(Reside reside) {
        initSession();

        IResideDao dao = session.getMapper(IResideDao.class);
        dao.insertResideTable(reside);

        session.commit();
        closeAll();

        return reside.getId();
    }

    @Override
    public void dropResideTable(Integer id) {
        initSession();

        IResideDao dao = session.getMapper(IResideDao.class);
        dao.dropResideTable(id);

        session.commit();
        closeAll();
    }

    @Override
    public void updateResideTable(Reside reside) {
        initSession();

        IResideDao dao = session.getMapper(IResideDao.class);
        dao.updateResideTable(reside);

        session.commit();
        closeAll();
    }

    @Override
    public List<Reside> selectResideTable(Integer id) {
        List<Reside> resides = null;
        initSession();

        IResideDao dao = session.getMapper(IResideDao.class);
        resides = dao.selectResideTable(id);

        closeAll();
        return resides;
    }
}
