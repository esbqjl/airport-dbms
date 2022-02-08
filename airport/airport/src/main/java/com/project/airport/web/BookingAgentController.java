package com.project.airport.web;

import com.project.airport.bean.JsonResult;
import com.project.airport.bean.BookingAgent;
import com.project.airport.service.BookingAgentService;
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
public class BookingAgentController {
    @Autowired
    private BookingAgentService bookingAgentService;
    @RequestMapping(value="BookingAgent/{id}",method=RequestMethod.GET)
    public ResponseEntity<JsonResult> findBookingAgent (@PathVariable(value="id") int id){
        JsonResult r = new JsonResult();
        try{
            BookingAgent BookingAgent = bookingAgentService.findBookingAgent(id);
            r.setStatus("OK");
            r.setResult(BookingAgent);
        }catch(Exception e){
            r.setResult(e.getClass().getName()+":"+e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
    @RequestMapping(value="BookingAgents",method=RequestMethod.GET)
    public ResponseEntity<JsonResult> getBookingAgentList(){
        JsonResult r = new JsonResult();
        try{
            List<BookingAgent> BookingAgents = bookingAgentService.findBookingAgentList();
            r.setResult(BookingAgents);
            r.setStatus("OK");
        }catch(Exception e){
            r.setStatus("error");
            r.setResult(bookingAgentService.getClass().getName()+": "+e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);

    }
    @RequestMapping(value="BookingAgent",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody BookingAgent BookingAgent){
        JsonResult r= new JsonResult();
        try{
            int orderId = bookingAgentService.add(BookingAgent);
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
    @RequestMapping(value="BookingAgent/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete(@PathVariable(value="id") int id){
        JsonResult r = new JsonResult();
        try{
            int ret = bookingAgentService.delete(id);
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
    @RequestMapping(value = "BookingAgent/{id}",method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update(@PathVariable("id") int id, @RequestBody BookingAgent BookingAgent){
        JsonResult r = new JsonResult();

        try{
            int ret = bookingAgentService.update(id,BookingAgent);
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
