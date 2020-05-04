package com.carnote.service.impl;

import com.carnote.dao.ExpenseDAO;
import com.carnote.model.entity.Expense;
import com.carnote.model.entity.Vehicle;
import com.carnote.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseDAO expenseDAO;

    @Override
    @Transactional
    public void add(Expense expense) {
        expenseDAO.add(expense);
    }

    @Override
    @Transactional
    public void edit(Expense expense) {
        expenseDAO.edit(expense);
    }

    @Override
    @Transactional
    public void delete(int id) {
        expenseDAO.delete(id);
    }

    @Override
    @Transactional
    public Expense getExpense(int id) {
        return expenseDAO.getExpense(id);
    }

    @Override
    @Transactional
    public List getAllExpense(Vehicle car) {
        return expenseDAO.getAllExpense(car);
    }
}
