package com.project.airport.web;

import com.project.airport.bean.JsonResult;
import com.project.airport.bean.Store;
import com.project.airport.service.StoreService;
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
public class StoreController {
    @Autowired
    private StoreService storeService;
    @RequestMapping(value="Store/{name}/{airportName}",method=RequestMethod.GET)
    public ResponseEntity<JsonResult> findStore (@PathVariable String name, @PathVariable String airportName ){
        JsonResult r = new JsonResult();
        try{
            Store Store = storeService.findStore(name,airportName);
            r.setStatus("OK");
            r.setResult(Store);
        }catch(Exception e){
            r.setResult(e.getClass().getName()+":"+e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
    @RequestMapping(value="Stores",method=RequestMethod.GET)
    public ResponseEntity<JsonResult> getStoreList(){
        JsonResult r = new JsonResult();
        try{
            List<Store> Stores = storeService.findStoreList();
            r.setResult(Stores);
            r.setStatus("OK");
        }catch(Exception e){
            r.setStatus("error");
            r.setResult(storeService.getClass().getName()+": "+e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);

    }
    @RequestMapping(value="Store",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody Store Store){
        JsonResult r= new JsonResult();
        try{
            int orderId = storeService.add(Store);
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
    @RequestMapping(value="Store/{name}/{airportName}",method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete(@PathVariable(value="name") String name,@PathVariable(value="airportName") String airportName){
        JsonResult r = new JsonResult();
        try{
            int ret = storeService.delete(name,airportName);
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
    @RequestMapping(value = "Store/{name}/{airportName}",method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update(@PathVariable("name") String name,@PathVariable(value="airportName") String airportName, @RequestBody Store Store){
        JsonResult r = new JsonResult();

        try{
            int ret = storeService.update(name,airportName,Store);
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
