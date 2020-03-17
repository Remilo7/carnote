package com.carnote.dao.impl;

import com.carnote.dao.UserInfoDAO;
import com.carnote.model.entity.UserInfo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserInfoDAOImpl implements UserInfoDAO {

    @Autowired
    private SessionFactory session;

    public void add(UserInfo user) {
        session.getCurrentSession().save(user);
    }

    public void edit(UserInfo user) {
        session.getCurrentSession().update(user);
    }

    public void delete(String username) {
        session.getCurrentSession().delete(findUserInfo(username));
    }

    public UserInfo findUserInfo(String userName) {
        return session.getCurrentSession().get(UserInfo.class, userName);
    }

    public List getAllUserInfo(){
        return session.getCurrentSession().createQuery("FROM UserInfo").list();
    }
}