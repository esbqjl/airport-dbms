package com.project.airport.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org. springframework.stereotype.Repository;

import com.project.airport.dao.WorkerDao;
import com.project.airport.bean.Worker;
@Repository
public class WorkerDaoJdbcTemplateImpl implements WorkerDao{
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public int add(Worker worker){
        String sql = "insert into worker(airport_name,name, age, salary, store_name,job)" +
                "values(:airport_name,:name, :age, :salary, :store_name,:job)";
        Map<String,Object> param = new HashMap<>();
        param.put("airport_name",worker.getAirportName());
        param.put("name",worker.getName());
        param.put("age",worker.getAge());
        param.put("salary",worker.getSalary());
        param.put("store_name",worker.getStoreName());
        param.put("job",worker.getJob());
        return (int) jdbcTemplate.update(sql, param);
    }
    @Override
    public int update(int id,Worker worker){
        Map<String,Object> param = new HashMap<>();
        param.put("airport_name",worker.getAirportName());
        param.put("name",worker.getName());
        param.put("age",worker.getAge());
        param.put("salary",worker.getSalary());
        param.put("store_name",worker.getStoreName());
        param.put("job",worker.getJob());
        param.put("id",id);
        return (int) jdbcTemplate.update("UPDATE worker SET airport_name=:airport_name,name=:name, age=:age, salary=:salary, store_name=:store_name,job=:job where id= :id",param);


    }
    @Override
    public int delete(int id){
        Map<String,Object> param = new HashMap<>();
        param.put("id",id);
        return (int) jdbcTemplate.update("DELETE from worker where id=:id",param);
    }
    @Override
    public Worker findWorker (int id){
        Map<String,Object> param = new HashMap<>();
        param.put("id", id);
        List<Worker> list =jdbcTemplate.query("Select * from worker where id = :id",param,new BeanPropertyRowMapper(Worker.class));
        if(list!=null&list.size()>0){
            return list.get(0);
        }else{
            return null;
        }

    }
    @Override
    public List<Worker> findWorkerList(){
        List<Worker> list = jdbcTemplate.query("select * from worker",new BeanPropertyRowMapper(Worker.class) );

        if(list!=null&list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
