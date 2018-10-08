package com.airplanes.xyzAirline.Controller;

import com.airplanes.xyzAirline.Model.Airplane;
import com.airplanes.xyzAirline.Model.OutOfFuelException;
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

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        planeRepository.deleteById(id);
    }

    @PostMapping("/post")
    public Airplane createAirplane(@RequestBody Airplane newAirplane) {
        return planeRepository.save(newAirplane);
    }

    @RequestMapping("/fly/{id}")
    public Airplane plainFlight(@PathVariable int id) throws OutOfFuelException {
        Airplane tempPlaine = planeRepository.findById(id).get();
        tempPlaine.fly();
        return planeRepository.save(tempPlaine);
    }

    @RequestMapping("/tank/{id}")
    public Airplane plainTank(@PathVariable int id) {
        Airplane tempPlaine = planeRepository.findById(id).get();
        tempPlaine.tank();
        return planeRepository.save(tempPlaine);
    }

}
