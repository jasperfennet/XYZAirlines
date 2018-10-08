package com.airplanes.xyzAirline.Model;

public class OutOfFuelException extends Exception {

    public OutOfFuelException() {
        super("Not Enough Fuel left to Fly");
    }
}
