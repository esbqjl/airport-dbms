package com.project.airport.bean;

public class BookingAgent {
    private String id;
    private String bookingCompanyName;
    private String agentName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAgentName() {
        return agentName;
    }

    public String getBookingCompanyName() {
        return bookingCompanyName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public void setBookingCompanyName(String bookingCompanyName) {
        this.bookingCompanyName = bookingCompanyName;
    }
}