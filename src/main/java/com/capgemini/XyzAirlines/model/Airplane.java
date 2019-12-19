package com.capgemini.XyzAirlines.model;

import javax.persistence.*;

@Entity
@Table(name = "Airplane")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String airplaneNr;
    @Column
    private String airplaneType;
    @Column
    private String currentLocation;
    @Column
    private String destinationLocation;
    @Column
    private int fuelInTank;
    @Transient
    public Airport airport;

    public Airplane() {
    }

    public Airplane(long id, String airplaneNr, String airplaneType, String currentLocation, String destinationLocation, int fuelInTank) {
        this.id = id;
        this.airplaneNr = airplaneNr;
        this.airplaneType = airplaneType;
        this.currentLocation = currentLocation;
        this.destinationLocation = destinationLocation;
        this.fuelInTank = fuelInTank;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAirplaneNr() {
        return airplaneNr;
    }

    public void setAirplaneNr(String airplaneNr) {
        this.airplaneNr = airplaneNr;
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public int getFuelInTank() {
        return fuelInTank;
    }

    public void setFuelInTank(int fuelInTank) {
        this.fuelInTank = fuelInTank;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    //Bijtanken van een vliegtuig met een druk op de knop
    public void tankingFuel(){
        fuelInTank = 5;

    }

    //D.m.v. druk op knop vliegen van ene vliegveld naar andere (instant)
    public void flying (String currentLocation, String destinationLocation){
        currentLocation = destinationLocation;
    }

}
