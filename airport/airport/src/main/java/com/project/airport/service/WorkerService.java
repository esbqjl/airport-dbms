package com.project.airport.service;
import com.project.airport.bean.Worker;
import org.springframework.stereotype.Service;
import java.util.List;
public interface WorkerService {
    int add(Worker Worker);

    int update(int id,Worker Worker);

    int delete(int id);

    Worker findWorker(int id);

    List<Worker> findWorkerList();

}
