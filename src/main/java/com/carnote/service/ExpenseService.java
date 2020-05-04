package com.carnote.service;

import com.carnote.model.entity.Expense;
import com.carnote.model.entity.Vehicle;

import java.util.List;

public interface ExpenseService {

    public void add(Expense expense);
    public void edit(Expense expense);
    public void delete(int id);
    public Expense getExpense(int id);
    public List getAllExpense(Vehicle car);
}
