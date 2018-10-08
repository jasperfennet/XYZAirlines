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
    public static final int MAX_PLANE_FUEL = 5;
    public static final int TANK_INCREMENT = 2;

    public Airplane() {
    }

    public Airplane(int fuel) {
        this.fuel = fuel;
    }

    public int getFuel() {
        return fuel;
    }

    public void Tank() {
        if ((this.fuel + TANK_INCREMENT) >= MAX_PLANE_FUEL){
            this.fuel = MAX_PLANE_FUEL;
        }
        else {
            this.fuel += TANK_INCREMENT;
        }

    }

    public int getplaneId() {
        return planeId;
    }

    public void setplaneId(int planeId) {
        this.planeId = planeId;
    }
}
