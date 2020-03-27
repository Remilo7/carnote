package com.carnote.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLES")
public class Vehicle {

    @Id
    private int id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private int year;

    @Column
    private int ftype;

    @Column
    private int cap1;

    @Column
    private int cap2;

    @Column
    private int level1;

    @Column
    private int level2;

    @Column
    private int milage;

    public Vehicle() {
    }

    public Vehicle(int id, String brand, String model, int year, int ftype, int cap1, int level1, int milage) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.ftype = ftype;
        this.cap1 = cap1;
        this.level1 = level1;
        this.milage = milage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getFtype() {
        return ftype;
    }

    public void setFtype(int ftype) {
        this.ftype = ftype;
    }

    public int getCap1() {
        return cap1;
    }

    public void setCap1(int cap1) {
        this.cap1 = cap1;
    }

    public int getCap2() {
        return cap2;
    }

    public void setCap2(int cap2) {
        this.cap2 = cap2;
    }

    public int getLevel1() {
        return level1;
    }

    public void setLevel1(int level1) {
        this.level1 = level1;
    }

    public int getLevel2() {
        return level2;
    }

    public void setLevel2(int level2) {
        this.level2 = level2;
    }

    public int getMilage() {
        return milage;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }
}
