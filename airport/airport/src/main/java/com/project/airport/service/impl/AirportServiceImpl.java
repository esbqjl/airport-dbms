package com.project.airport.service.impl;
import com.project.airport.service.AirportService;
import com.project.airport.bean.Airport;
import com.project.airport.dao.AirportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService{
    @Autowired
    private AirportDao AirportDao;
    @Override
    public int add(Airport Airport){
        return AirportDao.add(Airport);
    }
    @Override
    public int update(String id, Airport Airport){
        return AirportDao.update(id,Airport);
    }
    @Override
    public int delete(String id){
        return AirportDao.delete(id);
    }
    @Override
    public Airport findAirport(String id){
        return AirportDao.findAirport(id);
    }
    @Override
    public List<Airport> findAirportList(){
        return AirportDao.findAirportList();
    }
}
