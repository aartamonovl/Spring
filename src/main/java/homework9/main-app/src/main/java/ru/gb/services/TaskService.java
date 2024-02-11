package ru.gb.services;

import org.springframework.stereotype.Service;
import ru.gb.models.Task;
import ru.gb.models.TaskStatus;
import ru.gb.repositories.ITaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final ITaskRepository repository;

    public TaskService(ITaskRepository repository) {
        this.repository = repository;
    }


    public Task addTask(Task task) {
        task.setCreationDate(LocalDateTime.now());
        return repository.save(task);
    }


    public List<Task> getAllTasks() {
        return repository.findAll();
    }


    public List<Task> getTaskByStatus(TaskStatus status) {
        return repository.findTasksByStatus(status);
    }


    public Task updateTaskStatus(Long id, Task taskDetails) {
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setStatus(taskDetails.getStatus());
            return repository.save(task);
        } else {
            throw new IllegalArgumentException("Not found task with id: " + id);
        }
    }


    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
