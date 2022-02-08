package com.project.airport.service;
import com.project.airport.bean.Ticket;
import org.springframework.stereotype.Service;
import java.util.List;
public interface TicketService {
    int add(Ticket ticket);

    int update(int orderNumber,Ticket ticket);

    int delete(int orderNumber);

    Ticket findTicket(int orderNumber);

    List<Ticket> findTicketList();

}
