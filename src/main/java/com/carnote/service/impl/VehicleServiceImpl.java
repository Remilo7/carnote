package com.carnote.service.impl;

import com.carnote.dao.VehicleDAO;
import com.carnote.model.entity.Vehicle;
import com.carnote.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleDAO vehicleDAO;

    @Override
    @Transactional
    public int add(Vehicle vehicle) {
        return vehicleDAO.add(vehicle);
    }

    @Override
    @Transactional
    public void edit(Vehicle vehicle) {
        vehicleDAO.edit(vehicle);
    }

    @Override
    @Transactional
    public void delete(int id) {
        vehicleDAO.delete(id);
    }

    @Override
    @Transactional
    public Vehicle getVehicle(int id) {
        return vehicleDAO.getVehicle(id);
    }

    @Override
    @Transactional
    public List getAllVehicles() {
        return vehicleDAO.getAllVehicles();
    }
}
