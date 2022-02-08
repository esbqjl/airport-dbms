package com.project.airport.service.impl;
import com.project.airport.service.WorkerService;
import com.project.airport.bean.Worker;
import com.project.airport.dao.WorkerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService{
    @Autowired
    private WorkerDao WorkerDao;
    @Override
    public int add(Worker Worker){
        return WorkerDao.add(Worker);
    }
    @Override
    public int update(int id, Worker Worker){
        return WorkerDao.update(id,Worker);
    }
    @Override
    public int delete(int id){
        return WorkerDao.delete(id);
    }
    @Override
    public Worker findWorker(int id){
        return WorkerDao.findWorker(id);
    }
    @Override
    public List<Worker> findWorkerList(){
        return WorkerDao.findWorkerList();
    }
}
