package com.airplanes.xyzAirline.Model;

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
    void Tank() {
        plaines.get(1).Tank();
        assertEquals(Airplane.MAX_PLANE_FUEL,plaines.get(1).getFuel());

        plaines.get(0).Tank();
        assertEquals(2,plaines.get(0).getFuel());
    }

}