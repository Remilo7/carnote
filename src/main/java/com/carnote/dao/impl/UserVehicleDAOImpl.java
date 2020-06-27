package com.carnote.dao.impl;

import com.carnote.dao.UserVehicleDAO;
import com.carnote.model.entity.UserInfo;
import com.carnote.model.entity.UserVehicle;
import com.carnote.model.entity.Vehicle;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserVehicleDAOImpl implements UserVehicleDAO {

    @Autowired
    private SessionFactory session;

    @Override
    public void add(UserVehicle userVehicle) {
        session.getCurrentSession().save(userVehicle);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete(getUserVehicle(id));
    }

    @Override
    public UserVehicle getUserVehicle(int id) {
        return session.getCurrentSession().get(UserVehicle.class, id);
    }

    @Override
    public String getOwner(Vehicle vehicle) {

        String hql = "FROM UserVehicle uv WHERE uv.vehicle=:v";

        List result = session.getCurrentSession().createQuery(hql)
                .setParameter("v", vehicle)
                .list();

        if (!result.isEmpty())
            return ((UserVehicle)result.get(0)).getUser().getUsername();

        return null;
    }

    @Override
    public List getAllUserVehicles(UserInfo user) {

        String hql = "FROM UserVehicle uv WHERE uv.user=:u";

        List result = session.getCurrentSession().createQuery(hql)
                .setParameter("u", user)
                .list();

        return result;
    }
}
