package com.project.airport.web;

import com.project.airport.bean.JsonResult;
import com.project.airport.bean.Purchase;
import com.project.airport.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;
    @RequestMapping(value="Purchase/{ticketOrderNumber}",method=RequestMethod.GET)
    public ResponseEntity<JsonResult> findPurchase (@PathVariable(value="ticketOrderNumber") int ticketOrderNumber){
        JsonResult r = new JsonResult();
        try{
            Purchase Purchase = purchaseService.findPurchase(ticketOrderNumber);
            r.setStatus("OK");
            r.setResult(Purchase);
        }catch(Exception e){
            r.setResult(e.getClass().getName()+":"+e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
    @RequestMapping(value="Purchases",method=RequestMethod.GET)
    public ResponseEntity<JsonResult> getPurchaseList(){
        JsonResult r = new JsonResult();
        try{
            List<Purchase> Purchases = purchaseService.findPurchaseList();
            r.setResult(Purchases);
            r.setStatus("OK");
        }catch(Exception e){
            r.setStatus("error");
            r.setResult(purchaseService.getClass().getName()+": "+e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);

    }
    @RequestMapping(value="Purchase",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody Purchase Purchase){
        JsonResult r= new JsonResult();
        try{
            int orderId = purchaseService.add(Purchase);
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
    @RequestMapping(value="Purchase/{ticketOrderNumber}",method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete(@PathVariable(value="ticketOrderNumber") int ticketOrderNumber){
        JsonResult r = new JsonResult();
        try{
            int ret = purchaseService.delete(ticketOrderNumber);
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
    @RequestMapping(value = "Purchase/{ticketOrderNumber}",method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update(@PathVariable("ticketOrderNumber") int ticketOrderNumber, @RequestBody Purchase Purchase){
        JsonResult r = new JsonResult();

        try{
            int ret = purchaseService.update(ticketOrderNumber,Purchase);
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
