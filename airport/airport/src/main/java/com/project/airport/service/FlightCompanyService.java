package com.project.airport.service;
import com.project.airport.bean.FlightCompany;
import org.springframework.stereotype.Service;
import java.util.List;
public interface FlightCompanyService {
    int add(FlightCompany flightCompany);

    int update(int id,FlightCompany flightCompany);

    int delete(int id);

    FlightCompany findFlightCompany(int id);

    List<FlightCompany> findFlightCompanyList();

}
