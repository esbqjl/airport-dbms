package com.project.airport.dao;



import java.util.List;

import com.project.airport.bean.Purchase;

public interface PurchaseDao{

    int add(Purchase purchase);

    int update(int ticketOrderNumber,Purchase purchase);

    int delete(int ticketOrderNumber);

    Purchase findPurchase(int ticketOrderNumber);

    List<Purchase> findPurchaseList();
}