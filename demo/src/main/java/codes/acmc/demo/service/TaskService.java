package codes.acmc.demo.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import codes.acmc.demo.Task;
import codes.acmc.demo.repository.TaskRepository;

@Service
public class TaskService implements ITaskService {
    @Autowired
    private TaskRepository repository;

    @Override
    public List<Task> findAll() {

        List<Task> tasks = (List<Task>) repository.findAll();

        return tasks;
    }

    @Async("taskExecutor")
    @Override
    public void asyncTestMethod() {
        try {
            Thread.sleep(3000);
            LoggerFactory.getLogger(TaskService.class).warn("Se ha completado la tarea");
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        }
    }
}