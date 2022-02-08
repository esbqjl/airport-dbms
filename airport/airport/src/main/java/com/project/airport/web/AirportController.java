package com.project.airport.web;

import com.project.airport.bean.JsonResult;
import com.project.airport.bean.Airport;
import com.project.airport.service.AirportService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class AirportController {


    @Autowired
    private AirportService airportService;

    @RequestMapping(value="Airport/{id}",method=RequestMethod.GET)
    public ResponseEntity<JsonResult> findAirport (@PathVariable(value="id") String id){
        JsonResult r = new JsonResult();
        try{
            Airport Airport = airportService.findAirport(id);
            r.setStatus("OK");
            r.setResult(Airport);
        }catch(Exception e){
            r.setResult(e.getClass().getName()+":"+e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    @RequestMapping(value="Airports",method=RequestMethod.GET)
    public ResponseEntity<JsonResult> getAirportList(){
        JsonResult r = new JsonResult();
        try{
            List<Airport> Airports = airportService.findAirportList();
            r.setResult(Airports);
            r.setStatus("OK");
        }catch(Exception e){
            r.setStatus("error");
            r.setResult(airportService.getClass().getName()+": "+e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);

    }
    @RequestMapping(value="Airport",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody Airport Airport){
        JsonResult r= new JsonResult();
        try{
            int orderId = airportService.add(Airport);
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
    @RequestMapping(value="Airport/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete(@PathVariable(value="id") String id){
        JsonResult r = new JsonResult();
        try{
            int ret = airportService.delete(id);
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
    @RequestMapping(value = "Airport/{id}",method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update(@PathVariable("id") String id, @RequestBody Airport Airport){
        JsonResult r = new JsonResult();

        try{
            int ret = airportService.update(id,Airport);
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
