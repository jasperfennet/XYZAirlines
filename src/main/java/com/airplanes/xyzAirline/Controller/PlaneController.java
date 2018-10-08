package com.airplanes.xyzAirline.Controller;

import com.airplanes.xyzAirline.Model.Airplane;
import com.airplanes.xyzAirline.Repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/plane")
public class PlaneController {

    @Autowired
    private PlaneRepository planeRepository;

    @RequestMapping("/all")
    public Iterable<Airplane> list() {
        return planeRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Airplane getById(@PathVariable int id) {
        return planeRepository.findById(id).get();
    }

    @PostMapping("/post")
    public Airplane createAirplane(@RequestBody Airplane newAirplane) {
        return planeRepository.save(newAirplane);
    }


}
