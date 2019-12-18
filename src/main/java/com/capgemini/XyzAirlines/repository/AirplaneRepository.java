package com.capgemini.XyzAirlines.repository;

import com.capgemini.XyzAirlines.model.Airplane;
import org.springframework.data.repository.CrudRepository;

public interface AirplaneRepository extends CrudRepository<Airplane, Long> {
    //repositories are interfaces with methods supporting reading, updating, deleting,
    // and creating records against a back end data store

    Iterable<Airplane> findByAirplaneNrContainingIgnoreCase(String airplaneNr);
    Iterable<Airplane> findByAirplaneNr(String airplaneNr);

}
