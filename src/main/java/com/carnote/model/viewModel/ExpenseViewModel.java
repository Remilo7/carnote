package com.carnote.model.viewModel;

import com.carnote.model.entity.ExpType;
import com.carnote.model.entity.Expense;
import com.carnote.model.entity.FuelExpense;

public class ExpenseViewModel {

    private int id;
    private String name;
    private ExpType type;
    private String date;
    private int milage;
    private float price;

    public ExpenseViewModel() {
    }

    public ExpenseViewModel(int id, String name, ExpType type, String date, int milage, float price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.date = date;
        this.milage = milage;
        this.price = price;
    }

    public ExpenseViewModel(Expense expense) {
        id = expense.getId();
        name = expense.getName();
        type = expense.getType();
        date = expense.getDate();
        milage = expense.getMilage();
        price = expense.getPrice();
    }

    public ExpenseViewModel(FuelExpense expense) {
        id = expense.getId();
        name = expense.getName();
        type = expense.getType();
        date = expense.getDate();
        milage = expense.getMilage();
        price = expense.getPrice();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExpType getType() {
        return type;
    }

    public void setType(ExpType type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMilage() {
        return milage;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
