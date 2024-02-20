package ru.gb.controllers;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;
import ru.gb.models.Task;
import ru.gb.models.TaskStatus;
import ru.gb.observer.AddTaskEvent;
import ru.gb.services.FileGateway;
import ru.gb.services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/main-app")
public class TaskController {

    /**
     * Сервис обработки задач
     */
    private final TaskService service;
    private final FileGateway fileGateway;
    private final ApplicationEventPublisher publisher;

    public TaskController(TaskService service, FileGateway fileGateway, ApplicationEventPublisher publisher) {
        this.service = service;
        this.fileGateway = fileGateway;
        this.publisher = publisher;
    }

    /**
     * Добавление задачи
     *
     * @param task задача
     * @return задача
     */
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        Task newTask = service.addTask(task);
        if (newTask == null){
            return null;
        }
        publisher.publishEvent(new AddTaskEvent(this, newTask));
        return newTask;
    }

    /**
     * Получение всех задач
     *
     * @return лист задач
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    /**
     * Получение списка задач по статусу
     *
     * @param status статус
     * @return лист задач
     */
    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus(@PathVariable TaskStatus status) {
        return service.getTaskByStatus(status);
    }

    /**
     * Обновление задачи
     *
     * @param task обновленная задача
     * @return задача
     */
    @PutMapping()
    public Task updateTaskStatus(@RequestBody Task task) {
        return service.updateTaskStatus(task);
    }

    /**
     * Удаление задачи
     *
     * @param id идентификатор задачи
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }
}
