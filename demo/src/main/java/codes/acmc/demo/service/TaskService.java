package codes.acmc.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}