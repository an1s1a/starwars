package com.starwarsapp.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Vehicle implements Serializable {

    public String name;


    @SerializedName("vehicle_class")
    public String vehicleClass;

    public Vehicle(String name, String model, String vehicleClass, String length) {
        this.name = name;
        this.vehicleClass = vehicleClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(String vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

}