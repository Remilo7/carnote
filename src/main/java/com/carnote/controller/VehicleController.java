package com.carnote.controller;

import com.carnote.model.entity.Vehicle;
import com.carnote.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(value = {"/newVehicle" }, method = RequestMethod.GET)
    public String indexPage(Map<String, Object> map) {

        map.put("vehicle", new Vehicle());
        return "newVehicle";
    }

    @RequestMapping(value="/addVehicle", method= RequestMethod.POST)
    public String doActions(@Valid @ModelAttribute Vehicle vehicle, BindingResult br) {

        if (br.hasErrors()) {
            return "newVehicle";
        }

        else {

            vehicleService.add(vehicle);

            return "redirect:/index";
        }
    }
}
