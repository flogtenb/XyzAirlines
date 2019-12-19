package com.capgemini.XyzAirlines.service;

import com.capgemini.XyzAirlines.model.Airplane;
import com.capgemini.XyzAirlines.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
@Transactional
public class AirplaneService {

    @Autowired
    private AirplaneRepository airplaneRepository;

    public AirplaneService(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    //One example usage of @PostConstruct is populating a database
    @PostConstruct
    public void init() {
        Airplane a1 = new Airplane();
        a1.setAirplaneNr("KL666");
        a1.setFuelInTank(3);
        a1.setCurrentLocation("London");
        a1.setDestinationLocation("New York");
        a1.setAirplaneType("Boeing");
    }

    public Iterable<Airplane> listAll() {
        return airplaneRepository.findAll();
    }

    public Airplane save(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }
}
