package com.carnote.dao.impl;

import com.carnote.dao.UserRoleDAO;
import com.carnote.model.entity.UserRole;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRoleDAOImpl implements UserRoleDAO {

    @Autowired
    private SessionFactory session;

    public void add(UserRole userRole) {
        session.getCurrentSession().save(userRole);
    }

    public void edit(UserRole userRole) {
        session.getCurrentSession().update(userRole);
    }

    public void delete(int id) {
        session.getCurrentSession().delete(getUserRole(id));
    }

    public UserRole getUserRole(int id) {
        return session.getCurrentSession().get(UserRole.class, id);
    }

    public List getAllUserRoles(String username) {

        String sql = "FROM UserRole WHERE username='"+username+"'";
        return session.getCurrentSession().createQuery(sql).list();
    }
}