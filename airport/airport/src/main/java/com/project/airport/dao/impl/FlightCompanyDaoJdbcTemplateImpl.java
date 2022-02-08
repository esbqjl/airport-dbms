package com.project.airport.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org. springframework.stereotype.Repository;

import com.project.airport.dao.FlightCompanyDao;
import com.project.airport.bean.FlightCompany;
@Repository
public class FlightCompanyDaoJdbcTemplateImpl implements FlightCompanyDao{
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public int add(FlightCompany flightCompany){
        String sql = "insert into flightCompany(id,flight_company_name)" +
                "values(:id, :flight_company_name)";
        Map<String,Object> param = new HashMap<>();
        param.put("id",flightCompany.getId());
        param.put("flight_company_name",flightCompany.getFlightCompanyName());
        return (int) jdbcTemplate.update(sql, param);
    }
    @Override
    public int update(int id,FlightCompany flightCompany){
        Map<String,Object> param = new HashMap<>();
        param.put("flight_company_name",flightCompany.getFlightCompanyName());
        param.put("id",id);
        return (int) jdbcTemplate.update("UPDATE flightCompany SET flight_company_name=:flight_company_name where id= :id",param);


    }
    @Override
    public int delete(int id){
        Map<String,Object> param = new HashMap<>();
        param.put("id",id);
        return (int) jdbcTemplate.update("DELETE from flightCompany where id=:id",param);
    }
    @Override
    public FlightCompany findFlightCompany (int id){
        Map<String,Object> param = new HashMap<>();
        param.put("id", id);
        List<FlightCompany> list =jdbcTemplate.query("Select * from flightCompany where id = :id",param,new BeanPropertyRowMapper(FlightCompany.class));
        if(list!=null&list.size()>0){
            return list.get(0);
        }else{
            return null;
        }

    }
    @Override
    public List<FlightCompany> findFlightCompanyList(){
        List<FlightCompany> list = jdbcTemplate.query("select * from flightCompany",new BeanPropertyRowMapper(FlightCompany.class) );

        if(list!=null&list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
