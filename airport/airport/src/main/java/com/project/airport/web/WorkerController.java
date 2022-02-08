package com.project.airport.web;

import com.project.airport.bean.JsonResult;
import com.project.airport.bean.Worker;
import com.project.airport.service.WorkerService;
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
public class WorkerController {
    @Autowired
    private WorkerService workerService;
    @RequestMapping(value="Worker/{id}",method=RequestMethod.GET)
    public ResponseEntity<JsonResult> findWorker (@PathVariable(value="id") int id){
        JsonResult r = new JsonResult();
        try{
            Worker Worker = workerService.findWorker(id);
            r.setStatus("OK");
            r.setResult(Worker);
        }catch(Exception e){
            r.setResult(e.getClass().getName()+":"+e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
    @RequestMapping(value="Workers",method=RequestMethod.GET)
    public ResponseEntity<JsonResult> getWorkerList(){
        JsonResult r = new JsonResult();
        try{
            List<Worker> Workers = workerService.findWorkerList();
            r.setResult(Workers);
            r.setStatus("OK");
        }catch(Exception e){
            r.setStatus("error");
            r.setResult(workerService.getClass().getName()+": "+e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);

    }
    @RequestMapping(value="Worker",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody Worker Worker){
        JsonResult r= new JsonResult();
        try{
            int orderId = workerService.add(Worker);
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
    @RequestMapping(value="Worker/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete(@PathVariable(value="id") int id){
        JsonResult r = new JsonResult();
        try{
            int ret = workerService.delete(id);
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
    @RequestMapping(value = "Worker/{id}",method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update(@PathVariable("id") int id, @RequestBody Worker Worker){
        JsonResult r = new JsonResult();

        try{
            int ret = workerService.update(id,Worker);
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
