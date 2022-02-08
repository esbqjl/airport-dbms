package com.project.airport.service.impl;
import com.project.airport.service.TicketService;
import com.project.airport.bean.Ticket;
import com.project.airport.dao.TicketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    private TicketDao TicketDao;
    @Override
    public int add(Ticket ticket){
        return TicketDao.add(ticket);
    }
    @Override
    public int update(int orderNumber, Ticket ticket){
        return TicketDao.update(orderNumber,ticket);
    }
    @Override
    public int delete(int orderNumber){
        return TicketDao.delete(orderNumber);
    }
    @Override
    public Ticket findTicket(int orderNumber){
        return TicketDao.findTicket(orderNumber);
    }
    @Override
    public List<Ticket> findTicketList(){
        return TicketDao.findTicketList();
    }
}
