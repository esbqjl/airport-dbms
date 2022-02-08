package com.project.airport.dao;



import java.util.List;

import com.project.airport.bean.Ticket;

public interface TicketDao{

    int add(Ticket ticket);

    int update(int ticketOrderNumber,Ticket ticket);

    int delete(int ticketOrderNumber);

    Ticket findTicket(int ticketOrderNumber);

    List<Ticket> findTicketList();
}