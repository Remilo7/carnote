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

        float fuel_sum = fuelExpenses.stream()
                .map(x -> x.getPrice())
                .reduce((float)0, Float::sum);

        float exp_sum = expenses.stream()
                .filter(x -> x.getType().getId()==1)
                .map(x -> x.getPrice())
                .reduce((float)0, Float::sum);

        float rep_sum = expenses.stream()
                .filter(x -> x.getType().getId()==2)
                .map(x -> x.getPrice())
                .reduce((float)0, Float::sum);

        float mot_sum = expenses.stream()
                .filter(x -> x.getType().getId()==3)
                .map(x -> x.getPrice())
                .reduce((float)0, Float::sum);

        float ins_sum = expenses.stream()
                .filter(x -> x.getType().getId()==4)
                .map(x -> x.getPrice())
                .reduce((float)0, Float::sum);

        float oth_sum = expenses.stream()
                .filter(x -> x.getType().getId()==5)
                .map(x -> x.getPrice())
                .reduce((float)0, Float::sum);

        float sum = fuel_sum+exp_sum+rep_sum+mot_sum+ins_sum+oth_sum;

        map.put("vehicle", vehicle);
        map.put("expense", new ExpenseViewModel());
        map.put("expenseList", expenseList);

        map.put("fuel_sum", fuel_sum);
        map.put("exp_sum", exp_sum);
        map.put("rep_sum", rep_sum);
        map.put("mot_sum", mot_sum);
        map.put("ins_sum", ins_sum);
        map.put("oth_sum", oth_sum);
        map.put("sum", sum);

        return "vehicle";
    }
}
