package codes.acmc.demo.service;

import java.util.List;
import codes.acmc.demo.Task;

public interface ITaskService {
    List<Task> findAll();
}