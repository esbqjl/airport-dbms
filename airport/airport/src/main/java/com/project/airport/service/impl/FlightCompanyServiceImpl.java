package com.project.airport.service.impl;
import com.project.airport.service.FlightCompanyService;
import com.project.airport.bean.FlightCompany;
import com.project.airport.dao.FlightCompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightCompanyServiceImpl implements FlightCompanyService{
    @Autowired
    private FlightCompanyDao FlightCompanyDao;
    @Override
    public int add(FlightCompany flightCompany){
        return FlightCompanyDao.add(flightCompany);
    }
    @Override
    public int update(int id, FlightCompany flightCompany){
        return FlightCompanyDao.update(id,flightCompany);
    }
    @Override
    public int delete(int id){
        return FlightCompanyDao.delete(id);
    }
    @Override
    public FlightCompany findFlightCompany(int id){
        return FlightCompanyDao.findFlightCompany(id);
    }
    @Override
    public List<FlightCompany> findFlightCompanyList(){
        return FlightCompanyDao.findFlightCompanyList();
    }
}
