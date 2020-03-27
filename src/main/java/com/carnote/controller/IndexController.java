package com.carnote.controller;

import com.carnote.model.entity.Vehicle;
import com.carnote.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String indexPage(Map<String, Object> map) {


        map.put("vehicle", new Vehicle());
        map.put("vehicleList", vehicleService.getAllVehicles());
        return "index";
    }
}
