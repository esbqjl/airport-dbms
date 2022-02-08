package com.project.airport.dao;



import java.util.List;

import com.project.airport.bean.BookingAgent;

public interface BookingAgentDao{

    int add(BookingAgent bookingAgent);

    int update(int id,BookingAgent bookingAgent);

    int delete(int id);

    BookingAgent findBookingAgent(int id);

    List<BookingAgent> findBookingAgentList();
}