package com.carnote.authentication;

import com.carnote.model.entity.Expense;
import com.carnote.model.entity.FuelExpense;
import com.carnote.model.entity.Vehicle;
import com.carnote.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "userVehicleEvaluator")
public class UserVehicleEvaluatorImpl implements UserVehicleEvaluator {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    UserVehicleService userVehicleService;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    ExpenseService expenseService;

    @Autowired
    FuelExpenseService fuelExpenseService;

    @Override
    public boolean isUserVehicle(int vehicleId, String username) {

        Vehicle vehicle = vehicleService.getVehicle(vehicleId);
        String ownerName = userVehicleService.getOwner(vehicle);

        return username.equals(ownerName);
    }

    @Override
    public boolean isUserExpense(int expenseId, String username) {

        Expense expense = expenseService.getExpense(expenseId);

        if (expense != null) {
            Vehicle vehicle = expense.getCar();
            String ownerName = userVehicleService.getOwner(vehicle);

            return username.equals(ownerName);
        }

        return false;
    }

    @Override
    public boolean isUserFuelExpense(int expenseId, String username) {

        FuelExpense expense = fuelExpenseService.getFuelExpense(expenseId);

        if (expense != null) {
            Vehicle vehicle = expense.getCar();
            String ownerName = userVehicleService.getOwner(vehicle);

            return username.equals(ownerName);
        }

        return false;
    }
}
