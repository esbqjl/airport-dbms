package com.project.airport.service;
import com.project.airport.bean.Purchase;
import org.springframework.stereotype.Service;
import java.util.List;
public interface PurchaseService {
    int add(Purchase purchase);

    int update(int ticket_order_number,Purchase purchase);

    int delete(int ticket_order_number);

    Purchase findPurchase(int ticket_order_number);

    List<Purchase> findPurchaseList();

}
