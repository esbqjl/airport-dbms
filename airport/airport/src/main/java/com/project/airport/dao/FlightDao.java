package com.project.airport.dao;



import java.util.List;

import com.project.airport.bean.Flight;

public interface FlightDao{

    int add(Flight flight);

    int update(int id,Flight flight);

    int delete(int id);

    Flight findFlight(int id );

    List<Flight> findFlightList();
}