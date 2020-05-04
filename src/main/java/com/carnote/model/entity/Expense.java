package com.carnote.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "EXPENSES")
public class Expense {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "car")
    private Vehicle car;

    @Column
    @Length(max = 50, message = "Too long name!")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type")
    private ExpType type;

    @Column
    private String date;

    @Column
    @Min(value = 0, message = "Improper value!")
    private int milage;

    @Column
    @Min(value = 0, message = "Improper value!")
    private float price;

    @Column
    @Length(max = 500, message = "Too long description!")
    private String description;

    public Expense() {
    }

    public Expense(int id, Vehicle car, String name, ExpType type, String date, int milage, float price, String description) {
        this.id = id;
        this.car = car;
        this.name = name;
        this.type = type;
        this.date = date;
        this.milage = milage;
        this.price = price;
        this.description = description;
    }

    public Expense(Vehicle car, String name, ExpType type, String date, int milage, float price, String description) {
        this.car = car;
        this.name = name;
        this.type = type;
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
