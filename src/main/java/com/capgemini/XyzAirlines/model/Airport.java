package com.capgemini.XyzAirlines.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private int maxAmountPlanes;
    @Column
    @ManyToMany
    public List<Airplane> airplanes;

    public Airport() {}

    public Airport(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxAmountPlanes() {
        return maxAmountPlanes;
    }

    public void setMaxAmountPlanes(int maxAmountPlanes) {
        this.maxAmountPlanes = maxAmountPlanes;
    }

    public List<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(List<Airplane> airplanes) {
        this.airplanes = airplanes;
    }
}
