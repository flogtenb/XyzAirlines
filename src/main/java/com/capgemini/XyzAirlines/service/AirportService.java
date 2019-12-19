package com.capgemini.XyzAirlines.service;

import com.capgemini.XyzAirlines.model.Airport;
import com.capgemini.XyzAirlines.repository.AirplaneRepository;
import com.capgemini.XyzAirlines.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
@Transactional
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private AirplaneRepository airplaneRepository;

    @PostConstruct
    public void init() {
        Airport a = new Airport();
        a.setName("London");

        Airport b = new Airport();
        b.setName("Brussel");

        Airport c = new Airport();
        c.setName("Milan");
    }

    public void save(Airport airport) {
        airportRepository.save(airport);
    }


    public Iterable<Airport> getAirports() {
        return this.airportRepository.findAll();
    }

    public void newAirport(Airport airport) {
        this.airportRepository.save(airport);
    }

}
