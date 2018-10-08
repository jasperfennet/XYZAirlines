package com.airplanes.xyzAirline.Repository;

import com.airplanes.xyzAirline.Model.Airplane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends CrudRepository<Airplane,Integer> {
}
