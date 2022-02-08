package com.project.airport.service;
import com.project.airport.bean.BookingAgent;
import org.springframework.stereotype.Service;
import java.util.List;
public interface BookingAgentService {
    int add(BookingAgent bookingAgent);

    int update(int id,BookingAgent bookingAgent);

    int delete(int id);

    BookingAgent findBookingAgent(int id);

    List<BookingAgent> findBookingAgentList();

}
