package com.project.airport.service.impl;
import com.project.airport.service.StoreService;
import com.project.airport.bean.Store;
import com.project.airport.dao.StoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService{
    @Autowired
    private StoreDao StoreDao;
    @Override
    public int add(Store Store){
        return StoreDao.add(Store);
    }
    @Override
    public int update(String name,String airportName, Store Store){
        return StoreDao.update(name,airportName,Store);
    }
    @Override
    public int delete(String name,String airportName){
        return StoreDao.delete(name, airportName);
    }
    @Override
    public Store findStore(String name, String airportName){
        return StoreDao.findStore(name,airportName);
    }
    @Override
    public List<Store> findStoreList(){
        return StoreDao.findStoreList();
    }
}
