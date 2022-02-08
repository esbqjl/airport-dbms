package com.project.airport.service;
import com.project.airport.bean.Airport;
import org.springframework.stereotype.Service;
import java.util.List;
public interface AirportService {
    int add(Airport Airport);

    int update(String id,Airport Airport);

    int delete(String id);

    Airport findAirport(String id);

    List<Airport> findAirportList();

}
