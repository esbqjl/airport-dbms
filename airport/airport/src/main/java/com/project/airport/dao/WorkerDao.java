package com.project.airport.dao;



import java.util.List;

import com.project.airport.bean.Worker;

public interface WorkerDao{

    int add(Worker worker);

    int update(int id,Worker worker);

    int delete(int id);

    Worker findWorker(int id);

    List<Worker> findWorkerList();
}