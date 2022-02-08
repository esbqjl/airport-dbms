package com.project.airport.web;

import com.project.airport.bean.JsonResult;
import com.project.airport.bean.Supplier;
import com.project.airport.service.SupplierService;
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
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @RequestMapping(value="Supplier/{id}",method=RequestMethod.GET)
    public ResponseEntity<JsonResult> findSupplier (@PathVariable(value="id") String id){
        JsonResult r = new JsonResult();
        try{
            Supplier Supplier = supplierService.findSupplier(id);
            r.setStatus("OK");
            r.setResult(Supplier);
        }catch(Exception e){
            r.setResult(e.getClass().getName()+":"+e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
    @RequestMapping(value="Suppliers",method=RequestMethod.GET)
    public ResponseEntity<JsonResult> getSupplierList(){
        JsonResult r = new JsonResult();
        try{
            List<Supplier> Suppliers = supplierService.findSupplierList();
            r.setResult(Suppliers);
            r.setStatus("OK");
        }catch(Exception e){
            r.setStatus("error");
            r.setResult(supplierService.getClass().getName()+": "+e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);

    }
    @RequestMapping(value="Supplier",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody Supplier Supplier){
        JsonResult r= new JsonResult();
        try{
            int orderId = supplierService.add(Supplier);
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
    @RequestMapping(value="Supplier/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete(@PathVariable(value="id") String id){
        JsonResult r = new JsonResult();
        try{
            int ret = supplierService.delete(id);
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
    @RequestMapping(value = "Supplier/{id}",method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update(@PathVariable("id") String id, @RequestBody Supplier Supplier){
        JsonResult r = new JsonResult();

        try{
            int ret = supplierService.update(id,Supplier);
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
