package com.carnote.dao;

import com.carnote.model.entity.Vehicle;

import java.util.List;

public interface VehicleDAO {

    public void add(Vehicle vehicle);
    public void edit(Vehicle vehicle);
    public void delete(int id);
    public Vehicle getVehicle(int id);
    public List getAllVehicles();
}
