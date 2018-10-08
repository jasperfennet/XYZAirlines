package com.airplanes.xyzAirline.Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AirplaneTest {

    private List<Airplane> plaines;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        plaines = new ArrayList<>();
        plaines.add(new Airplane(0));
        plaines.add(new Airplane(Airplane.MAX_PLANE_FUEL));

    }

    @org.junit.jupiter.api.Test
    void getFuel() {
        assertEquals(Airplane.MAX_PLANE_FUEL, plaines.get(1).getFuel());
        assertEquals(0, plaines.get(0).getFuel());
    }

    @org.junit.jupiter.api.Test
    void tank() {
        plaines.get(1).tank();
        assertEquals(Airplane.MAX_PLANE_FUEL,plaines.get(1).getFuel());

        plaines.get(0).tank();
        assertEquals(2,plaines.get(0).getFuel());
    }

    @Test
    void fly() throws OutOfFuelException {
       assertThrows(OutOfFuelException.class ,()->plaines.get(0).fly(),"Not Enough Fuel left to Fly");
       plaines.get(1).fly();
       assertEquals(3, plaines.get(1).getFuel());

    }
}