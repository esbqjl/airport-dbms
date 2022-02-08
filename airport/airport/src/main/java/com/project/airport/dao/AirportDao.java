package com.project.airport.dao;



import java.util.List;

import com.project.airport.bean.Airport;

public interface AirportDao{

    int add(Airport airport);

    int update(String id,Airport airport);

    int delete(String id);

    Airport findAirport(String id);

    List<Airport> findAirportList();
}
