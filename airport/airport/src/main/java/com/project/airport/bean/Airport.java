package com.project.airport.bean;

public class Airport {
    private String id;
    private String city;
    private String name;

    public void setId(String id){
        this.id = id;
    }
    public void setCity(String city){
        this.city=city;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getId(){
        return this.id;
    }
    public String getCity(){
        return this.city;
    }
    public String getName(){
        return this.name;
    }
}