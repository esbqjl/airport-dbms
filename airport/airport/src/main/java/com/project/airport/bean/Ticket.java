package com.project.airport.bean;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
public class Ticket {
    private int orderNumber;
    private String passengerName;
    private String flightNumber;
    private String flightCompany;
    private String seatClass;
    private Double price;

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Double getPrice() {
        return price;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public String getFlightCompany() {
        return flightCompany;
    }

    public void setFlightCompany(String flightCompany) {
        this.flightCompany = flightCompany;
    }
}