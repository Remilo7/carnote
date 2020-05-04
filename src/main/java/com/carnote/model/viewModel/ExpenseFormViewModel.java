package com.carnote.model.viewModel;

public class ExpenseFormViewModel {

    private int id;
    private int carId;
    private String name;
    private int typeId;
    private String date;
    private int milage;
    private float price;
    private String description;

    public ExpenseFormViewModel() {
    }

    public ExpenseFormViewModel(int id, int carId, String name, int typeId, String date, int milage, float price, String description) {
        this.id = id;
        this.carId = carId;
        this.name = name;
        this.typeId = typeId;
        this.date = date;
        this.milage = milage;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
