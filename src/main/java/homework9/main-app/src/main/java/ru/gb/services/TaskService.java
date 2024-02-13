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

    /**
     * Репозиторий
     */
    private final ITaskRepository repository;

    public TaskService(ITaskRepository repository) {
        this.repository = repository;
    }

    /**
     * Добавление задачи
     * @param task задача
     * @return задача
     */
    public Task addTask(Task task) {
        task.setCreationDate(LocalDateTime.now());
        return repository.save(task);
    }

    /**
     * Получение всех задач
     * @return лист всех задач
     */
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    /**
     * Получение задачи по статусу
     * @param status статус
     * @return лист задач
     */
    public List<Task> getTaskByStatus(TaskStatus status) {
        return repository.findTasksByStatus(status);
    }

    /**
     * Обновление статуса задачи
     * @param taskDetails измененная задача
     * @return задача
     */
    public Task updateTaskStatus(Task taskDetails) {
        Optional<Task> optionalTask = repository.findById(taskDetails.getId());
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setStatus(taskDetails.getStatus());
            return repository.save(task);
        } else {
            throw new IllegalArgumentException("Not found task with id: " + taskDetails.getId());
        }
    }

    /**
     * Удаление задачи по id
     * @param id идентификатор задачи
     */
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
