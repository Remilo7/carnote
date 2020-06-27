package com.carnote.controller;

import com.carnote.model.entity.UserVehicle;
import com.carnote.model.entity.Vehicle;
import com.carnote.service.UserInfoService;
import com.carnote.service.UserVehicleService;
import com.carnote.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class IndexController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    UserVehicleService userVehicleService;

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String indexPage(Principal principal, Map<String, Object> map) {


        List<Vehicle> allVehicles = vehicleService.getAllVehicles();
        List<UserVehicle> userVehicles = userVehicleService.getAllUserVehicles(userInfoService.findUserInfo(principal.getName()));

        List<Vehicle> vehicles = allVehicles.stream()
                .filter(e -> userVehicles.stream()
                .anyMatch(f -> e.getId() == f.getVehicle().getId()))
                .collect(Collectors.toList());

        map.put("vehicle", new Vehicle());
        map.put("vehicleList", vehicles);
        return "index";
    }
}
