package com.project.airport.service;
import com.project.airport.bean.Store;
import org.springframework.stereotype.Service;
import java.util.List;
public interface StoreService {
    int add(Store Store);

    int update(String name,String airportName,Store Store);

    int delete(String name,String airportName);

    Store findStore(String name,String airportName);

    List<Store> findStoreList();

}
