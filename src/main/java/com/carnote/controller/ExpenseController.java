package com.carnote.controller;

import com.carnote.model.entity.Expense;
import com.carnote.model.entity.FuelExpense;
import com.carnote.model.entity.Vehicle;
import com.carnote.model.viewModel.ExpenseFormViewModel;
import com.carnote.model.viewModel.FuelExpenseFormViewModel;
import com.carnote.service.ExpTypeService;
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
import java.util.Map;

@Controller
public class ExpenseController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    ExpenseService expenseService;

    @Autowired
    FuelExpenseService fuelExpenseService;

    @Autowired
    ExpTypeService expTypeService;

    @RequestMapping(value="/newExpense", method = RequestMethod.GET)
    public String newExpensePage(Map<String, Object> map, @RequestParam(value = "vId") Integer vehicleId) {

        Vehicle vehicle = vehicleService.getVehicle(vehicleId);

        map.put("expense", new ExpenseFormViewModel());
        map.put("vehicle", vehicle);
        return "newExpense";
    }

    @RequestMapping(value="/editExpense", method = RequestMethod.GET)
    public String editExpensePage(Map<String, Object> map, @RequestParam(value = "eId") Integer expenseId) {

        Expense expense = expenseService.getExpense(expenseId);

        map.put("oldExpense", expense);
        map.put("expense", new ExpenseFormViewModel());
        return "editExpense";
    }

    @RequestMapping(value="/deleteExpense", method = RequestMethod.GET)
    public String deleteExpense(@RequestParam(value = "eId") Integer expenseId) {

        int vehicleId = expenseService.getExpense(expenseId).getCar().getId();

        expenseService.delete(expenseId);

        return "redirect:/vehicle?vId="+vehicleId;
    }

    @RequestMapping(value="/addExpense", method= RequestMethod.POST)
    public String addExpense(@Valid @ModelAttribute ExpenseFormViewModel expense, BindingResult br) {

        int id = expense.getCarId();

        if (br.hasErrors()) {
            return "newExpense?vId="+id;
        }

        else {

            Expense expenseToAdd = new Expense(vehicleService.getVehicle(expense.getCarId()), expense.getName(), expTypeService.getExpType(expense.getTypeId()),
                    expense.getDate(), expense.getMilage(), expense.getPrice(), expense.getDescription());

            expenseService.add(expenseToAdd);

            return "redirect:/vehicle?vId="+id;
        }
    }

    @RequestMapping(value="/updateExpense", method= RequestMethod.POST)
    public String updateExpense(@Valid @ModelAttribute ExpenseFormViewModel expense, BindingResult br) {

        int id = expense.getCarId();

        if (br.hasErrors()) {
            return "newExpense?vId="+id;
        }

        else {

            Expense expenseToAdd = new Expense(expense.getId(), vehicleService.getVehicle(expense.getCarId()), expense.getName(),
                    expTypeService.getExpType(expense.getTypeId()), expense.getDate(), expense.getMilage(), expense.getPrice(), expense.getDescription());

            expenseService.edit(expenseToAdd);

            return "redirect:/vehicle?vId="+id;
        }
    }

    @RequestMapping(value="/expense", method = RequestMethod.GET)
    public String expensePage(Map<String, Object> map, @RequestParam(value = "eId") Integer expenseId) {

        Expense expense = expenseService.getExpense(expenseId);

        map.put("expense", expense);
        return "expense";
    }

    @RequestMapping(value="/newFuelExpense", method = RequestMethod.GET)
    public String newFuelExpensePage(Map<String, Object> map, @RequestParam(value = "vId") Integer vehicleId, @RequestParam(value = "ft") Integer fType) {

        Vehicle vehicle = vehicleService.getVehicle(vehicleId);

        map.put("expense", new FuelExpenseFormViewModel());
        map.put("vehicle", vehicle);
        map.put("fuel", fType);
        return "newFuelExpense";
    }

    @RequestMapping(value="/addFuelExpense", method= RequestMethod.POST)
    public String addFuelExpense(@Valid @ModelAttribute FuelExpenseFormViewModel expense, BindingResult br) {

        int id = expense.getCarId();

        if (br.hasErrors()) {
            return "newExpense?vId="+id;
        }

        else {

            FuelExpense expenseToAdd = new FuelExpense(vehicleService.getVehicle(expense.getCarId()), expense.getName(), expTypeService.getExpType(expense.getTypeId()),
                    expense.getFtype(), expense.getDate(), expense.getMilage(), expense.getPrice(), expense.getLitres(), expense.getLevel());

            fuelExpenseService.add(expenseToAdd);

            return "redirect:/vehicle?vId="+id;
        }
    }
}
