package com.capgemini.XyzAirlines.repository;

import com.capgemini.XyzAirlines.model.Airport;
import org.springframework.data.repository.CrudRepository;

public interface AirportRepository extends CrudRepository<Airport, Long> {
}
