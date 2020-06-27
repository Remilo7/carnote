package com.carnote.authentication;

public interface UserVehicleEvaluator {

    public boolean isUserVehicle(int vehicleId, String username);
    public boolean isUserExpense(int expenseId, String username);
    public boolean isUserFuelExpense(int expenseId, String username);
}
