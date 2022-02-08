package com.project.airport.web;

import com.project.airport.bean.JsonResult;
import com.project.airport.bean.Ticket;
import com.project.airport.service.TicketService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @RequestMapping(value="Ticket/{orderNumber}",method=RequestMethod.GET)
    public ResponseEntity<JsonResult> findTicket (@PathVariable(value="orderNumber") int orderNumber){
        JsonResult r = new JsonResult();
        try{
            Ticket Ticket = ticketService.findTicket(orderNumber);
            r.setStatus("OK");
            r.setResult(Ticket);
        }catch(Exception e){
            r.setResult(e.getClass().getName()+":"+e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
    @RequestMapping(value="Tickets",method=RequestMethod.GET)
    public ResponseEntity<JsonResult> getTicketList(){
        JsonResult r = new JsonResult();
        try{
            List<Ticket> Tickets = ticketService.findTicketList();
            r.setResult(Tickets);
            r.setStatus("OK");
        }catch(Exception e){
            r.setStatus("error");
            r.setResult(ticketService.getClass().getName()+": "+e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);

    }
    @RequestMapping(value="Ticket",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody Ticket Ticket){
        JsonResult r= new JsonResult();
        try{
            int orderId = ticketService.add(Ticket);
            if(orderId<0){
                r.setStatus("fail");
                r.setResult(orderId);
            }else{
                r.setStatus("OK");
                r.setResult(orderId);
            }
        }catch(Exception e){
            r.setResult(e.getClass()+":"+e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
    @RequestMapping(value="Ticket/{orderNumber}",method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete(@PathVariable(value="orderNumber") int orderNumber){
        JsonResult r = new JsonResult();
        try{
            int ret = ticketService.delete(orderNumber);
            if(ret<0){
                r.setStatus("fail");
                r.setResult(ret);
            }else{
                r.setStatus("OK");
                r.setResult(ret);
            }
        }catch(Exception e){
            r.setResult(e.getClass()+":"+e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
    @RequestMapping(value = "Ticket/{orderNumber}",method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update(@PathVariable("orderNumber") int orderNumber, @RequestBody Ticket Ticket){
        JsonResult r = new JsonResult();

        try{
            int ret = ticketService.update(orderNumber,Ticket);
            if(ret<0){
                r.setStatus("fail");
                r.setResult(ret);
            }else{
                r.setStatus("OK");
                r.setResult(ret);
            }
        }catch(Exception e){
            r.setResult(e.getClass()+":"+e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
}
