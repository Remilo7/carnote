package com.carnote.service.impl;

import com.carnote.dao.UserVehicleDAO;
import com.carnote.model.entity.UserInfo;
import com.carnote.model.entity.UserVehicle;
import com.carnote.model.entity.Vehicle;
import com.carnote.service.UserVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserVehicleServiceImpl implements UserVehicleService {

    @Autowired
    UserVehicleDAO userVehicleDAO;

    @Transactional
    @Override
    public void add(UserVehicle userVehicle) {
        userVehicleDAO.add(userVehicle);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userVehicleDAO.delete(id);
    }

    @Transactional
    @Override
    public UserVehicle getUserVehicle(int id) {
        return userVehicleDAO.getUserVehicle(id);
    }

    @Override
    @Transactional
    public String getOwner(Vehicle vehicle) {
        return userVehicleDAO.getOwner(vehicle);
    }

    @Transactional
    @Override
    public List getAllUserVehicles(UserInfo user) {
        return userVehicleDAO.getAllUserVehicles(user);
    }
}
