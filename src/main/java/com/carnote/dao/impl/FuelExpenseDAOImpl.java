package com.carnote.dao.impl;

import com.carnote.dao.FuelExpenseDAO;
import com.carnote.model.entity.FuelExpense;
import com.carnote.model.entity.Vehicle;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FuelExpenseDAOImpl implements FuelExpenseDAO {

    @Autowired
    private SessionFactory session;

    @Override
    public void add(FuelExpense fuelExpense) {
        session.getCurrentSession().save(fuelExpense);
    }

    @Override
    public void edit(FuelExpense fuelExpense) {
        session.getCurrentSession().update(fuelExpense);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete(getFuelExpense(id));
    }

    @Override
    public FuelExpense getFuelExpense(int id) {
        return session.getCurrentSession().get(FuelExpense.class, id);
    }

    @Override
    public List getAllFuelExpense(Vehicle car) {

        String hql = "FROM FuelExpense ex WHERE ex.car = :c";

        List result = session.getCurrentSession().createQuery(hql)
                .setParameter("c", car)
                .list();

        return result;
    }
}
