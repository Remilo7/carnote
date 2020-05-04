package com.carnote.service.impl;

import com.carnote.dao.FuelExpenseDAO;
import com.carnote.model.entity.FuelExpense;
import com.carnote.model.entity.Vehicle;
import com.carnote.service.FuelExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FuelExpenseServiceImpl implements FuelExpenseService {

    @Autowired
    FuelExpenseDAO fuelExpenseDAO;

    @Override
    @Transactional
    public void add(FuelExpense fuelExpense) {
        fuelExpenseDAO.add(fuelExpense);
    }

    @Override
    @Transactional
    public void edit(FuelExpense fuelExpense) {
        fuelExpenseDAO.edit(fuelExpense);
    }

    @Override
    @Transactional
    public void delete(int id) {
        fuelExpenseDAO.delete(id);
    }

    @Override
    @Transactional
    public FuelExpense getFuelExpense(int id) {
        return fuelExpenseDAO.getFuelExpense(id);
    }

    @Override
    @Transactional
    public List getAllFuelExpense(Vehicle car) {
        return fuelExpenseDAO.getAllFuelExpense(car);
    }
}
