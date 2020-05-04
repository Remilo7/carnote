package com.carnote.dao.impl;

import com.carnote.dao.ExpTypeDAO;
import com.carnote.model.entity.ExpType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExpTypeDAOImpl implements ExpTypeDAO {

    @Autowired
    private SessionFactory session;

    @Override
    public ExpType getExpType(int id) {
        return session.getCurrentSession().get(ExpType.class, id);
    }
}
