package codes.acmc.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import codes.acmc.demo.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    
}