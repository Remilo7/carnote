package com.carnote.dao;

import com.carnote.model.entity.FuelExpense;
import com.carnote.model.entity.Vehicle;

import java.util.List;

public interface FuelExpenseDAO {

    public void add(FuelExpense fuelExpense);
    public void edit(FuelExpense fuelExpense);
    public void delete(int id);
    public FuelExpense getFuelExpense(int id);
    public List getAllFuelExpense(Vehicle car);
}
