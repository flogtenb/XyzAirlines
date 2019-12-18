package com.capgemini.XyzAirlines.controller;

import com.capgemini.XyzAirlines.model.Airplane;
import com.capgemini.XyzAirlines.repository.AirplaneRepository;
import com.capgemini.XyzAirlines.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AirplaneController {
    //controller verwerkt en reageert op events, die meestal het
    // gevolg zijn van handelingen van de gebruiker
    private Airplane airplane;

    @Autowired
    private AirplaneService airplaneService;

    @Autowired
    private AirplaneRepository airplaneRepository;

    // Alle vliegtuigen ophalen
    @RequestMapping(value = "api/airplanes", method = RequestMethod.GET)
    public Iterable<Airplane> index() {
        return airplaneRepository.findAll();
    }

    //alle vliegtuigen ophalen
    @GetMapping(value = "api/airplaneslist", produces = "application/json")
    public ResponseEntity<Iterable<Airplane>> listAll() {
        Iterable<Airplane> airplanes = airplaneService.listAll();
        return new ResponseEntity<Iterable<Airplane>>(airplanes, HttpStatus.OK);
    }

    // nieuw vliegtuig opvoeren en bewaren
    @RequestMapping(value = "api/airplanesave", method = RequestMethod.POST)
    public ResponseEntity<Airplane> save(@RequestBody Airplane airplaneToSave) {
        return new ResponseEntity<>(airplaneRepository.save(airplaneToSave), HttpStatus.CREATED);
    }

    // Deletes a database item when clicked
    @RequestMapping(value = "api/airplanes/{id}", method = RequestMethod.DELETE)
    public void deleteAirplane(@PathVariable long id) {
        airplaneRepository.deleteById(id);
    }


    // Edit airplane
    @RequestMapping(value = "api/airplanes/{id}", method = RequestMethod.PUT)
    public void editAirplane(@PathVariable long id, @RequestBody Airplane airplaneToEdit) {
        airplaneRepository.save(airplaneToEdit);
    }

    // Find airplane
    @RequestMapping(value = "api/airplanes/search/{searchTerm}", method = RequestMethod.GET)
    public Iterable<Airplane> searchAirplane(@PathVariable String searchTerm) {
        return airplaneRepository.findByAirplaneNr(searchTerm);
    }


}
