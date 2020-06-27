package com.carnote.dao.impl;

import com.carnote.dao.VehicleDAO;
import com.carnote.model.entity.Vehicle;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehicleDAOImpl implements VehicleDAO {

    @Autowired
    SessionFactory session;

    @Override
    public int add(Vehicle vehicle) {
        return (Integer)session.getCurrentSession().save(vehicle);
    }

    @Override
    public void edit(Vehicle vehicle) {
        session.getCurrentSession().update(vehicle);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete(getVehicle(id));
    }

    @Override
    public Vehicle getVehicle(int id) {
        return session.getCurrentSession().get(Vehicle.class, id);
    }

    @Override
    public List getAllVehicles() {
        String hql = "FROM Vehicle ORDER BY brand";

        return session.getCurrentSession().createQuery(hql).list();
    }
}
