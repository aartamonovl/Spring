package ru.gb.homework5.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.gb.homework5.models.Task;
import ru.gb.homework5.models.TaskStatus;
import ru.gb.homework5.repositories.ITaskRepository;

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
