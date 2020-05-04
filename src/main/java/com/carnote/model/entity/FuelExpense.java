package com.carnote.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "FUEL_EXPENSES")
public class FuelExpense {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "car")
    private Vehicle car;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "type")
    private ExpType type;

    @Column
    private int ftype;

    @Column
    private String date;

    @Column
    @Min(value = 0, message = "Improper value!")
    private int milage;

    @Column
    @Min(value = 0, message = "Improper value!")
    private float price;

    @Column
    @Min(value = 0, message = "Improper value!")
    private float litres;

    @Column
    @Min(value = 0, message = "Improper value!")
    private float level;

    public FuelExpense() {
    }

    public FuelExpense(Vehicle car, String name, ExpType type, int ftype, String date, int milage, float price, float litres, float level) {
        this.car = car;
        this.name = name;
        this.ftype = ftype;
        this.type = type;
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

    public Vehicle getCar() {
        return car;
    }

    public void setCar(Vehicle car) {
        this.car = car;
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

    public float getLevel() {
        return level;
    }

    public void setLevel(float level) {
        this.level = level;
    }
}
