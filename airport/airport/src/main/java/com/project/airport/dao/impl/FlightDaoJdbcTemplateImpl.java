package com.project.airport.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org. springframework.stereotype.Repository;

import com.project.airport.dao.FlightDao;
import com.project.airport.bean.Flight;
@Repository
public class FlightDaoJdbcTemplateImpl implements FlightDao{
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public int add(Flight flight){
        String sql = "insert into flight(flight_number,departure_time, arrival_time, departure_airport, arrival_airport)" +
                "values(:flight_number,:departure_time, :arrival_time, :departure_airport, :arrival_airport)";
        Map<String,Object> param = new HashMap<>();
        param.put("flight_number",flight.getFlightNumber());
        param.put("departure_time",flight.getDepartureTime());
        param.put("arrival_time",flight.getArrivalTime());
        param.put("departure_airport",flight.getDepartureAirport());
        param.put("arrival_airport",flight.getArrivalAirport());

        return (int) jdbcTemplate.update(sql, param);
    }
    @Override
    public int update(int id,Flight flight){
        Map<String,Object> param = new HashMap<>();
        param.put("flight_number",flight.getFlightNumber());
        param.put("departure_time",flight.getDepartureTime());
        param.put("arrival_time",flight.getArrivalTime());
        param.put("departure_airport",flight.getDepartureAirport());
        param.put("arrival_airport",flight.getArrivalAirport());
        param.put("id",id);
        return (int) jdbcTemplate.update("UPDATE flight SET flight_number=:flight_number, departure_time=:departure_time, arrival_time=:arrival_time, departure_airport=:departure_airport, arrival_airport=:arrival_airport where id = :id",param);


    }
    @Override
    public int delete(int id){
        Map<String,Object> param = new HashMap<>();
        param.put("id",id);

        return (int) jdbcTemplate.update("DELETE from flight where id=:id",param);
    }
    @Override
    public Flight findFlight (int id){
        Map<String,Object> param = new HashMap<>();
        param.put("id", id);

        List<Flight> list =jdbcTemplate.query("Select * from flight where id=:id",param,new BeanPropertyRowMapper(Flight.class));
        if(list!=null&list.size()>0){
            return list.get(0);
        }else{
            return null;
        }

    }
    @Override
    public List<Flight> findFlightList(){
        List<Flight> list = jdbcTemplate.query("select * from flight",new BeanPropertyRowMapper(Flight.class) );

        if(list!=null&list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
