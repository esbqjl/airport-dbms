package com.project.airport.dao;



import java.util.List;

import com.project.airport.bean.Supplier;

public interface SupplierDao{

    int add(Supplier supplier);

    int update(String id,Supplier supplier);

    int delete(String id);

    Supplier findSupplier(String id);

    List<Supplier> findSupplierList();
}