package com.project.airport.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org. springframework.stereotype.Repository;

import com.project.airport.dao.BookingAgentDao;
import com.project.airport.bean.BookingAgent;
@Repository
public class BookingAgentDaoJdbcTemplateImpl implements BookingAgentDao{
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public int add(BookingAgent bookingAgent){
        String sql = "insert into bookingAgent(id,booking_company_name,agent_name)" +
                "values(:id, :booking_company_name, :agent_name)";
        Map<String,Object> param = new HashMap<>();
        param.put("id",bookingAgent.getId());
        param.put("booking_company_name",bookingAgent.getBookingCompanyName());
        param.put("agent_name",bookingAgent.getAgentName());

        return (int) jdbcTemplate.update(sql, param);
    }
    @Override
    public int update(int id,BookingAgent bookingAgent){
        Map<String,Object> param = new HashMap<>();
        param.put("booking_company_name",bookingAgent.getBookingCompanyName());
        param.put("agent_name",bookingAgent.getAgentName());
        param.put("id",id);
        return (int) jdbcTemplate.update("UPDATE bookingAgent SET booking_company_name=:booking_company_name, agent_name=:agent_name where id= :id",param);


    }
    @Override
    public int delete(int id){
        Map<String,Object> param = new HashMap<>();
        param.put("id",id);
        return (int) jdbcTemplate.update("DELETE from bookingAgent where id=:id",param);
    }
    @Override
    public BookingAgent findBookingAgent (int id){
        Map<String,Object> param = new HashMap<>();
        param.put("id", id);
        List<BookingAgent> list =jdbcTemplate.query("Select * from bookingAgent where id = :id",param,new BeanPropertyRowMapper(BookingAgent.class));
        if(list!=null&list.size()>0){
            return list.get(0);
        }else{
            return null;
        }

    }
    @Override
    public List<BookingAgent> findBookingAgentList(){
        List<BookingAgent> list = jdbcTemplate.query("select * from bookingAgent",new BeanPropertyRowMapper(BookingAgent.class) );

        if(list!=null&list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
