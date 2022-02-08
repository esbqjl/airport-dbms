package com.project.airport.web;

import com.project.airport.bean.JsonResult;
import com.project.airport.bean.Flight;
import com.project.airport.service.FlightService;
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
public class FlightController {
    @Autowired
    private FlightService flightService;
    @RequestMapping(value="Flight/{id}",method=RequestMethod.GET)
    public ResponseEntity<JsonResult> findFlight (@PathVariable(value="flightNumber") int id){
        JsonResult r = new JsonResult();
        try{
            Flight Flight = flightService.findFlight(id);
            r.setStatus("OK");
            r.setResult(Flight);
        }catch(Exception e){
            r.setResult(e.getClass().getName()+":"+e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
    @RequestMapping(value="Flights",method=RequestMethod.GET)
    public ResponseEntity<JsonResult> getFlightList(){
        JsonResult r = new JsonResult();
        try{
            List<Flight> Flights = flightService.findFlightList();
            r.setResult(Flights);
            r.setStatus("OK");
        }catch(Exception e){
            r.setStatus("error");
            r.setResult(flightService.getClass().getName()+": "+e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);

    }
    @RequestMapping(value="Flight",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody Flight Flight){
        JsonResult r= new JsonResult();
        try{
            int orderId = flightService.add(Flight);
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
    @RequestMapping(value="Flight/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete(@PathVariable(value="flightNumber") int id){
        JsonResult r = new JsonResult();
        try{
            int ret = flightService.delete(id);
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
    @RequestMapping(value = "Flight/{id}",method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update(@PathVariable("id") int id, @RequestBody Flight Flight){
        JsonResult r = new JsonResult();

        try{
            int ret = flightService.update(id, Flight);
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
