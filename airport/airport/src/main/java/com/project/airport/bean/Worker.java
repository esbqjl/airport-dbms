package com.project.airport.bean;

public class Worker {
    private String id;
    private String airportName;
    private String name;
    private int age;
    private int salary;
    private String storeName;
    private String job;

    public void setAge(int age) {
        this.age = age;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }



    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getAirportName() {
        return airportName;
    }

    public String getId() {
        return id;
    }

    public String getJob() {
        return job;
    }

    public String getStoreName() {
        return storeName;
    }

}


