package com.carnote.dao.impl;

import com.carnote.dao.ExpTypeDAO;
import com.carnote.model.entity.ExpType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExpTypeDAOImpl implements ExpTypeDAO {

    @Autowired
    private SessionFactory session;

    @Override
    public ExpType getExpType(int id) {
        return session.getCurrentSession().get(ExpType.class, id);
    }

    @Override
    public ExpType getExpTypeByName(String name) {

        String hql = "FROM ExpType ext WHERE ext.name = :n";

        List<ExpType> result = session.getCurrentSession().createQuery(hql)
                .setParameter("n", name)
                .list();

        return result.get(0);
    }
}
