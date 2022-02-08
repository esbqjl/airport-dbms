package com.project.airport.web;

import com.project.airport.bean.JsonResult;
import com.project.airport.bean.FlightCompany;
import com.project.airport.service.FlightCompanyService;
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
public class FlightCompanyController {
    @Autowired
    private FlightCompanyService flightCompanyService;
    @RequestMapping(value="FlightCompany/{id}",method=RequestMethod.GET)
    public ResponseEntity<JsonResult> findFlightCompany (@PathVariable(value="id") int id){
        JsonResult r = new JsonResult();
        try{
            FlightCompany flightCompany = flightCompanyService.findFlightCompany(id);
            r.setStatus("OK");
            r.setResult(flightCompany);
        }catch(Exception e){
            r.setResult(e.getClass().getName()+":"+e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
    @RequestMapping(value="FlightCompanies",method=RequestMethod.GET)
    public ResponseEntity<JsonResult> getFlightCompanyList(){
        JsonResult r = new JsonResult();
        try{
            List<FlightCompany> flightCompanies = flightCompanyService.findFlightCompanyList();
            r.setResult(flightCompanies);
            r.setStatus("OK");
        }catch(Exception e){
            r.setStatus("error");
            r.setResult(flightCompanyService.getClass().getName()+": "+e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);

    }
    @RequestMapping(value="FlightCompany",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody FlightCompany flightCompany){
        JsonResult r= new JsonResult();
        try{
            int orderId = flightCompanyService.add(flightCompany);
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
    @RequestMapping(value="FlightCompany/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete(@PathVariable(value="id") int id){
        JsonResult r = new JsonResult();
        try{
            int ret = flightCompanyService.delete(id);
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
    @RequestMapping(value = "FlightCompany/{id}",method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update(@PathVariable("id") int id, @RequestBody FlightCompany flightCompany){
        JsonResult r = new JsonResult();

        try{
            int ret = flightCompanyService.update(id,flightCompany);
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
