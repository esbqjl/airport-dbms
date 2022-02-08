package com.project.airport.service.impl;
import com.project.airport.service.BookingAgentService;
import com.project.airport.bean.BookingAgent;
import com.project.airport.dao.BookingAgentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingAgentServiceImpl implements BookingAgentService{
    @Autowired
    private BookingAgentDao BookingAgentDao;
    @Override
    public int add(BookingAgent bookingAgent){
        return BookingAgentDao.add(bookingAgent);
    }
    @Override
    public int update(int id, BookingAgent bookingAgent){
        return BookingAgentDao.update(id,bookingAgent);
    }
    @Override
    public int delete(int id){
        return BookingAgentDao.delete(id);
    }
    @Override
    public BookingAgent findBookingAgent(int id){
        return BookingAgentDao.findBookingAgent(id);
    }
    @Override
    public List<BookingAgent> findBookingAgentList(){
        return BookingAgentDao.findBookingAgentList();
    }
}
