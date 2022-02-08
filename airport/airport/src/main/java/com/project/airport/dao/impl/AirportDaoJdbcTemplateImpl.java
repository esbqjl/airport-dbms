package com.project.airport.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org. springframework.stereotype.Repository;

import com.project.airport.dao.AirportDao;
import com.project.airport.bean.Airport;
@Repository
public class AirportDaoJdbcTemplateImpl implements AirportDao{
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public int add(Airport airport){
        String sql = "insert into airport(id, name,city)" +
                "values(:id,:name,:city)";
        Map<String,Object> param = new HashMap<>();
        param.put("id",airport.getId());
        param.put("name",airport.getName());
        param.put("city",airport.getCity());

        return (int) jdbcTemplate.update(sql, param);
    }
    @Override
    public int update(String id,Airport airport){
        Map<String,Object> param = new HashMap<>();
        param.put("name",airport.getName());
        param.put("city",airport.getCity());
        param.put("id",id);
        return (int) jdbcTemplate.update("UPDATE airport SET  name=:name, city=:city WHERE id=:id ",param);


    }
    @Override
    public int delete(String id){
        Map<String,Object> param = new HashMap<>();
        param.put("id",id);
        return (int) jdbcTemplate.update("DELETE from airport where id=:id",param);
    }
    @Override
    public Airport findAirport (String id){
        Map<String,Object> param = new HashMap<>();
        param.put("id",id);
        List<Airport> list =jdbcTemplate.query("Select * from airport where id= :id",param,new BeanPropertyRowMapper(Airport.class));
        if(list!=null&list.size()>0){
            return list.get(0);
        }else{
            return null;
        }

    }
    @Override
    public List<Airport> findAirportList(){
        List<Airport> list = jdbcTemplate.query("select * from airport",new BeanPropertyRowMapper(Airport.class) );

        if(list!=null&list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
