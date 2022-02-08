package com.project.airport.service.impl;
import com.project.airport.service.SupplierService;
import com.project.airport.bean.Supplier;
import com.project.airport.dao.SupplierDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService{
    @Autowired
    private SupplierDao SupplierDao;
    @Override
    public int add(Supplier Supplier){
        return SupplierDao.add(Supplier);
    }
    @Override
    public int update(String id, Supplier Supplier){
        return SupplierDao.update(id,Supplier);
    }
    @Override
    public int delete(String id){
        return SupplierDao.delete(id);
    }
    @Override
    public Supplier findSupplier(String id){
        return SupplierDao.findSupplier(id);
    }
    @Override
    public List<Supplier> findSupplierList(){
        return SupplierDao.findSupplierList();
    }
}
