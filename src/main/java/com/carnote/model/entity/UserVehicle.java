package com.carnote.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "USER_VEHICLES")
public class UserVehicle {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserInfo user;

    @ManyToOne
    @JoinColumn(name = "vehicle")
    private Vehicle vehicle;

    public UserVehicle() {

    }

    public UserVehicle(UserInfo user, Vehicle vehicle) {
        this.user = user;
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
