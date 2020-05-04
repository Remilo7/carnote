package com.carnote.model.viewModel;

public class FuelExpenseFormViewModel {

    private int id;
    private int carId;
    private String name;
    private int typeId;
    private int ftype;
    private String date;
    private int milage;
    private float price;
    private float litres;
    private int level;

    public FuelExpenseFormViewModel() {
    }

    public FuelExpenseFormViewModel(int id, int carId, String name, int typeId, int ftype, String date, int milage, float price, float litres, int level) {
        this.id = id;
        this.carId = carId;
        this.name = name;
        this.typeId = typeId;
        this.ftype = ftype;
        this.date = date;
        this.milage = milage;
        this.price = price;
        this.litres = litres;
        this.level = level;
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

    public int getFtype() {
        return ftype;
    }

    public void setFtype(int ftype) {
        this.ftype = ftype;
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

    public float getLitres() {
        return litres;
    }

    public void setLitres(float litres) {
        this.litres = litres;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
