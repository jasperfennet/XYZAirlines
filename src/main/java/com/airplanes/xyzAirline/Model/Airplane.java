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
    public static final int FLIGHT_FUEL_COST = 2;

    public Airplane() {
    }

    public Airplane(int fuel) {
        this.fuel = fuel;
    }

    public int getFuel() {
        return fuel;
    }

    public void tank() {
        if ((this.fuel + TANK_INCREMENT) >= MAX_PLANE_FUEL) {
            this.fuel = MAX_PLANE_FUEL;
        } else {
            this.fuel += TANK_INCREMENT;
        }
    }

    public void fly() throws OutOfFuelException {
        if (this.fuel < FLIGHT_FUEL_COST) {
            throw new OutOfFuelException();
        } else {
            this.fuel -= FLIGHT_FUEL_COST;
        }
    }

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }
}
