package com.project.airport.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org. springframework.stereotype.Repository;

import com.project.airport.dao.SupplierDao;
import com.project.airport.bean.Supplier;
@Repository
public class SupplierDaoJdbcTemplateImpl implements SupplierDao{
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public int add(Supplier Supplier){
        String sql = "insert into Supplier(id,type)" +
                "values(:id,:type)";
        Map<String,Object> param = new HashMap<>();
        param.put("id",Supplier.getId());
        param.put("type",Supplier.getType());

        return (int) jdbcTemplate.update(sql, param);
    }
    @Override
    public int update(String id,Supplier Supplier){
        Map<String,Object> param = new HashMap<>();
        param.put("type",Supplier.getType());

        param.put("id",id);
        return (int) jdbcTemplate.update("UPDATE Supplier SET type=:type where id= :id",param);


    }
    @Override
    public int delete(String id){
        Map<String,Object> param = new HashMap<>();
        param.put("id",id);
        return (int) jdbcTemplate.update("DELETE from Supplier where id=:id",param);
    }
    @Override
    public Supplier findSupplier (String id){
        Map<String,Object> param = new HashMap<>();
        param.put("id", id);
        List<Supplier> list =jdbcTemplate.query("Select * from Supplier where id = :id",param,new BeanPropertyRowMapper(Supplier.class));
        if(list!=null&list.size()>0){
            return list.get(0);
        }else{
            return null;
        }

    }
    @Override
    public List<Supplier> findSupplierList(){
        List<Supplier> list = jdbcTemplate.query("select * from Supplier",new BeanPropertyRowMapper(Supplier.class) );

        if(list!=null&list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
