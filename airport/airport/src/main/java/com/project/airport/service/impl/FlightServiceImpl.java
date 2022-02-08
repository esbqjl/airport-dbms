package com.project.airport.service.impl;
import com.project.airport.service.FlightService;
import com.project.airport.bean.Flight;
import com.project.airport.dao.FlightDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{
    @Autowired
    private FlightDao FlightDao;
    @Override
    public int add(Flight Flight){
        return FlightDao.add(Flight);
    }
    @Override
    public int update(int id, Flight Flight){
        return FlightDao.update(id,Flight);
    }
    @Override
    public int delete(int id){
        return FlightDao.delete(id);
    }
    @Override
    public Flight findFlight(int id){
        return FlightDao.findFlight(id);
    }
    @Override
    public List<Flight> findFlightList(){
        return FlightDao.findFlightList();
    }
}
