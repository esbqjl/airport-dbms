package com.project.airport.service.impl;
import com.project.airport.service.PurchaseService;
import com.project.airport.bean.Purchase;
import com.project.airport.dao.PurchaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService{
    @Autowired
    private PurchaseDao PurchaseDao;
    @Override
    public int add(Purchase purchase){
        return PurchaseDao.add(purchase);
    }
    @Override
    public int update(int ticketOrderNumber, Purchase purchase){
        return PurchaseDao.update( ticketOrderNumber,purchase);
    }
    @Override
    public int delete(int ticketOrderNumber){
        return PurchaseDao.delete( ticketOrderNumber);
    }
    @Override
    public Purchase findPurchase(int ticketOrderNumber){
        return PurchaseDao.findPurchase(ticketOrderNumber);
    }
    @Override
    public List<Purchase> findPurchaseList(){
        return PurchaseDao.findPurchaseList();
    }
}
