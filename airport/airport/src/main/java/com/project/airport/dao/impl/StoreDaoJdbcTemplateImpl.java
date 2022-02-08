package com.project.airport.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org. springframework.stereotype.Repository;

import com.project.airport.dao.StoreDao;
import com.project.airport.bean.Store;
@Repository
public class StoreDaoJdbcTemplateImpl implements StoreDao{
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public int add(Store store){
        String sql = "insert into store(name,airport_name,product_type, type, place)" +
                "values(:name,:airport_name,:product_type, :type, :place)";
        Map<String,Object> param = new HashMap<>();
        param.put("name",store.getName());
        param.put("airport_name",store.getAirportName());
        param.put("product_type",store.getProductType());
        param.put("type",store.getType());
        param.put("place",store.getPlace());
        return (int) jdbcTemplate.update(sql, param);
    }
    @Override
    public int update(String name,String airportName,Store store){
        Map<String,Object> param = new HashMap<>();
        param.put("name",store.getName());
        param.put("airport_name",store.getAirportName());
        param.put("product_type",store.getProductType());
        param.put("type",store.getType());
        param.put("place",store.getPlace());
        param.put("name2",name);
        param.put("airport_name2",airportName);
        return (int) jdbcTemplate.update("UPDATE store SET  name=:name, airport_name=:airport_name, product_type=:product_type, type=:type, place=:place  WHERE name= :name2 AND airport_name = :airport_name2",param);


    }
    @Override
    public int delete(String name,String airportName){
        Map<String,Object> param = new HashMap<>();
        param.put("name",name);
        param.put("airport_name",airportName);
        return (int) jdbcTemplate.update("DELETE from store where name=:name AND airport_name =:airport_name",param);
    }
    @Override
    public Store findStore (String name, String airportName){
        Map<String,Object> param = new HashMap<>();
        param.put("name",name);
        param.put("airport_name",airportName);
        List<Store> list =jdbcTemplate.query("Select * from store where name = :name AND airport_name=:airport_name",param,new BeanPropertyRowMapper(Store.class));
        if(list!=null&list.size()>0){
            return list.get(0);
        }else{
            return null;
        }

    }
    @Override
    public List<Store> findStoreList(){
        List<Store> list = jdbcTemplate.query("select * from store",new BeanPropertyRowMapper(Store.class) );

        if(list!=null&list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
