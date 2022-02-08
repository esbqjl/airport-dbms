package com.project.airport.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org. springframework.stereotype.Repository;

import com.project.airport.dao.TicketDao;
import com.project.airport.bean.Ticket;
@Repository
public class TicketDaoJdbcTemplateImpl implements TicketDao{
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public int add(Ticket ticket){
        String sql = "insert into ticket(passenger_name,flight_number,flight_company, seat_class,price)" +
                "values(:passenger_name,:flight_number,:flight_company,:seat_class,:price)";
        Map<String,Object> param = new HashMap<>();
        param.put("passenger_name",ticket.getPassengerName());
        param.put("flight_number",ticket.getFlightNumber());
        param.put("flight_company",ticket.getFlightCompany());
        param.put("seat_class",ticket.getSeatClass());
        param.put("price",ticket.getPrice());

        return (int) jdbcTemplate.update(sql, param);
    }
    @Override
    public int update(int orderNumber,Ticket ticket){
        Map<String,Object> param = new HashMap<>();


        param.put("passenger_name",ticket.getPassengerName());
        param.put("flight_number",ticket.getFlightNumber());
        param.put("flight_company",ticket.getFlightCompany());
        param.put("seat_class",ticket.getSeatClass());
        param.put("price",ticket.getPrice());
        param.put("order_number",orderNumber);
        return (int) jdbcTemplate.update("UPDATE ticket SET passenger_name=:passenger_name,flight_number=:flight_number,flight_company=:flight_company, seat_class=:seat_class,price=:price where order_number = :order_number",param);


    }
    @Override
    public int delete(int orderNumber){
        Map<String,Object> param = new HashMap<>();
        param.put("order_number",orderNumber);
        return (int) jdbcTemplate.update("DELETE from ticket where order_number=:order_number",param);
    }
    @Override
    public Ticket findTicket (int orderNumber){
        Map<String,Object> param = new HashMap<>();
        param.put("order_number", orderNumber);
        List<Ticket> list =jdbcTemplate.query("Select * from ticket where order_number = :order_number",param,new BeanPropertyRowMapper(Ticket.class));
        if(list!=null&list.size()>0){
            return list.get(0);
        }else{
            return null;
        }

    }
    @Override
    public List<Ticket> findTicketList(){
        List<Ticket> list = jdbcTemplate.query("select * from ticket",new BeanPropertyRowMapper(Ticket.class) );

        if(list!=null&list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
