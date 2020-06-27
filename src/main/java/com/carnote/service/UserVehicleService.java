package com.carnote.service;

import com.carnote.model.entity.UserInfo;
import com.carnote.model.entity.UserVehicle;
import com.carnote.model.entity.Vehicle;

import java.util.List;

public interface UserVehicleService {

    public void add(UserVehicle userVehicle);
    public void delete(int id);
    public UserVehicle getUserVehicle(int id);
    public String getOwner(Vehicle vehicle);
    public List getAllUserVehicles(UserInfo user);
}
