package com.carnote.dao.impl;

import com.carnote.dao.ExpenseDAO;
import com.carnote.model.entity.Expense;
import com.carnote.model.entity.Vehicle;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExpenseDAOImpl implements ExpenseDAO {

    @Autowired
    private SessionFactory session;

    @Override
    public void add(Expense expense) {
        session.getCurrentSession().save(expense);
    }

    @Override
    public void edit(Expense expense) {
        session.getCurrentSession().update(expense);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete(getExpense(id));
    }

    @Override
    public Expense getExpense(int id) {
        return session.getCurrentSession().get(Expense.class, id);
    }

    @Override
    public List getAllExpense(Vehicle car) {

        String hql = "FROM Expense ex WHERE ex.car = :c";

        List result = session.getCurrentSession().createQuery(hql)
                .setParameter("c", car)
                .list();

        return result;
    }
}
