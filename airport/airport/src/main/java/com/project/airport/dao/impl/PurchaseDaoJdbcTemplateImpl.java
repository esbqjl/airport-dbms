package com.project.airport.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org. springframework.stereotype.Repository;

import com.project.airport.dao.PurchaseDao;
import com.project.airport.bean.Purchase;
@Repository
public class PurchaseDaoJdbcTemplateImpl implements PurchaseDao{
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public int add(Purchase Purchase){
        String sql = "insert into Purchase(flight_number,supplier_id,ticket_order_number)" +
                "values(:flight_number,:supplier_id,:ticket_order_number)";
        Map<String,Object> param = new HashMap<>();
        param.put("flight_number",Purchase.getFlightNumber());
        param.put("supplier_id",Purchase.getSupplierId());

        return (int) jdbcTemplate.update(sql, param);
    }
    @Override
    public int update(int ticketOrderNumber,Purchase Purchase){
        Map<String,Object> param = new HashMap<>();
        param.put("flight_number",Purchase.getFlightNumber());
        param.put("supplier_id",Purchase.getSupplierId());
        param.put("ticket_order_number",ticketOrderNumber);
        return (int) jdbcTemplate.update("UPDATE Purchase SET flight_number=:flight_number, supplier_id=:supplier_id,ticket_order_number=:ticket_order_number where ticket_order_number= :ticket_order_number",param);


    }
    @Override
    public int delete(int ticketOrderNumber){
        Map<String,Object> param = new HashMap<>();
        param.put("ticket_order_number",ticketOrderNumber);
        return (int) jdbcTemplate.update("DELETE from Purchase where ticket_order_number=:ticket_order_number",param);
    }
    @Override
    public Purchase findPurchase (int ticketOrderNumber){
        Map<String,Object> param = new HashMap<>();
        param.put("ticket_order_number",ticketOrderNumber);
        List<Purchase> list =jdbcTemplate.query("Select * from Purchase where ticket_order_number = :ticket_order_number",param,new BeanPropertyRowMapper(Purchase.class));
        if(list!=null&list.size()>0){
            System.out.println(list.get(0).getSupplierId());
            return list.get(0);
        }else{
            return null;
        }

    }
    @Override
    public List<Purchase> findPurchaseList(){
        List<Purchase> list = jdbcTemplate.query("select * from Purchase",new BeanPropertyRowMapper(Purchase.class) );

        if(list!=null&list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
