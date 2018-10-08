package com.airplanes.xyzAirline.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int planeId;

    private int fuel;

    public Airplane() {
    }

    public Airplane(int fuel) {
        this.fuel = fuel;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getplaneId() {
        return planeId;
    }

    public void setplaneId(int planeId) {
        this.planeId = planeId;
    }
}
