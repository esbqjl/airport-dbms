package com.project.airport.bean;

public class Purchase {
    private String flightNumber;
    private String supplierId;
    private int ticketOrderNumber;

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getTicketOrderNumber() {
        return ticketOrderNumber;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public void setTicketOrderNumber(int ticketOrderNumber) {
        this.ticketOrderNumber = ticketOrderNumber;
    }

}
