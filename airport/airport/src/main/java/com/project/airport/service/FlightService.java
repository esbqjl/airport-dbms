package com.project.airport.service;
import com.project.airport.bean.Flight;
import org.springframework.stereotype.Service;
import java.util.List;
public interface FlightService {
    int add(Flight flight);

    int update(int id,Flight flight);

    int delete(int id);

    Flight findFlight(int id);

    List<Flight> findFlightList();

}
