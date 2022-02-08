package com.project.airport.dao;



import java.util.List;

import com.project.airport.bean.Store;

public interface StoreDao{

    int add(Store store);

    int update(String name,String airportName,Store store);

    int delete(String name,String airportName);

    Store findStore(String name, String airportName);

    List<Store> findStoreList();
}