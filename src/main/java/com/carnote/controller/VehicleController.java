package com.carnote.controller;

import com.carnote.model.entity.Expense;
import com.carnote.model.entity.FuelExpense;
import com.carnote.model.entity.Vehicle;
import com.carnote.model.viewModel.ExpenseViewModel;
import com.carnote.service.ExpenseService;
import com.carnote.service.FuelExpenseService;
import com.carnote.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    ExpenseService expenseService;

    @Autowired
    FuelExpenseService fuelExpenseService;

    @RequestMapping(value="/newVehicle", method = RequestMethod.GET)
    public String newVehiclePage(Map<String, Object> map) {

        map.put("vehicle", new Vehicle());
        return "newVehicle";
    }

    @RequestMapping(value="/addVehicle", method= RequestMethod.POST)
    public String addVehicle(@Valid @ModelAttribute Vehicle vehicle, BindingResult br) {

        if (br.hasErrors()) {
            return "newVehicle";
        }

        else {

            vehicleService.add(vehicle);

            return "redirect:/index";
        }
    }

    @RequestMapping(value = "/vehicle", method = RequestMethod.GET)
    public String vehiclePage(Map<String, Object> map, @RequestParam(value = "vId", required = false) Integer vehicleId) {

        Vehicle vehicle = vehicleService.getVehicle(vehicleId);

        List<Expense> expenses = expenseService.getAllExpense(vehicle);
        List<FuelExpense> fuelExpenses = fuelExpenseService.getAllFuelExpense(vehicle);

        List<ExpenseViewModel> allExpenses = new ArrayList<>();

        expenses.forEach(e -> allExpenses.add(new ExpenseViewModel(e)));
        fuelExpenses.forEach(fe -> allExpenses.add(new ExpenseViewModel(fe)));

        List<ExpenseViewModel> expenseList = allExpenses.stream()
                .sorted((Comparator.comparing(ExpenseViewModel::getDate).reversed()))
                .collect(Collectors.toList());

        map.put("vehicle", vehicle);
        map.put("expense", new ExpenseViewModel());
        map.put("expenseList", expenseList);
        return "vehicle";
    }
}
