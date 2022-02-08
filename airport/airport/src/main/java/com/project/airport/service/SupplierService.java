package com.project.airport.service;
import com.project.airport.bean.Supplier;
import org.springframework.stereotype.Service;
import java.util.List;
public interface SupplierService {
    int add(Supplier Supplier);

    int update(String id,Supplier Supplier);

    int delete(String id);

    Supplier findSupplier(String id);

    List<Supplier> findSupplierList();

}
