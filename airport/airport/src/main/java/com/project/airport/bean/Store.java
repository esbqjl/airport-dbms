package com.project.airport.bean;

public class Store {
    private String name;
    private String airportName;
    private String productType;
    private String type;
    private String place;

    public void setName(String name) {
        this.name = name;
    }

    public void setAirport_name(String airportName) {
        this.airportName = airportName;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setProduct_type(String productType) {
        this.productType = productType;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAirportName() {
        return airportName;
    }

    public String getPlace() {
        return place;
    }

    public String getName() {
        return name;
    }

    public String getProductType() {
        return productType;
    }

    public String getType() {
        return type;
    }
}