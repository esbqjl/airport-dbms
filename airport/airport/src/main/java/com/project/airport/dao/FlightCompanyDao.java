package com.project.airport.dao;



import java.util.List;

import com.project.airport.bean.FlightCompany;

public interface FlightCompanyDao{

    int add(FlightCompany flightCompany);

    int update(int id,FlightCompany flightCompany);

    int delete(int id);

    FlightCompany findFlightCompany(int id);

    List<FlightCompany> findFlightCompanyList();
}