package com.doublezhuang.hotel.database.dao;

import com.doublezhuang.hotel.database.pojo.Member;
import jdk.nashorn.internal.objects.NativeUint8Array;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: hotel
 * @className: DaoImpl
 * @Description: 数据库接口实现
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/4/23 上午 11:38
 */
public class MemberDaoImpl implements IMemberDao {

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
    public Integer TableExist() {
        Integer result = null;
        initSession();

        IMemberDao dao = session.getMapper(IMemberDao.class);
        result = dao.TableExist();

        closeAll();
        return result;
    }

    @Override
    public void CreatMemberTable() {
        initSession();

        IMemberDao dao = session.getMapper(IMemberDao.class);
        dao.CreatMemberTable();

        session.commit();
        closeAll();
    }

    @Override
    public Integer InsertMember(Member member) {
        initSession();

        IMemberDao dao = session.getMapper(IMemberDao.class);
        dao.InsertMember(member);

        session.commit();
        closeAll();
        return member.getId();
    }

    @Override
    public List<Member> FindMember(String username) {
        List<Member> members = null;
        initSession();

        IMemberDao dao = session.getMapper(IMemberDao.class);
        members = dao.FindMember(username);

        closeAll();
        return members;
    }

    @Override
    public void UpdateMember(Member member) {
        initSession();

        IMemberDao dao = session.getMapper(IMemberDao.class);
        dao.UpdateMember(member);

        session.commit();
        closeAll();
    }
}
