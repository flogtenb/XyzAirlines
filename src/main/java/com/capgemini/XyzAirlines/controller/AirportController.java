package com.capgemini.XyzAirlines.controller;

import com.capgemini.XyzAirlines.model.Airplane;
import com.capgemini.XyzAirlines.model.Airport;
import com.capgemini.XyzAirlines.service.AirplaneService;
import com.capgemini.XyzAirlines.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AirportController {
    @Autowired
    private AirportService airportService;

    @Autowired
    private AirplaneService airplaneService;

    @RequestMapping(value = "api/airports", method = RequestMethod.GET)
    public Iterable<Airport> getAirports() {
        return airportService.getAirports();
    }

//    @RequestMapping(value = "api/airport", method = RequestMethod.POST)
//    public void addAirport(@RequestBody Airport airport) {
//        airportService.newAirport(airport);
//    }

    @CrossOrigin
    @PutMapping(value = "api/airport/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity saveAirport(@RequestBody final Airport airport) {
        List<Airplane> airplanes = airport.getAirplanes();

        for (int i = 0; i < airplanes.size(); i++) {
            Airplane airplane = airplaneService.save(airplanes.get(i));
            airplanes.set(i, airplane);
        }

        airport.setAirplanes(airplanes);
        airportService.save(airport);

        return ResponseEntity.ok().body(airport);
    }

}
