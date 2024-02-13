package ru.gb.controllers;

import org.springframework.web.bind.annotation.*;
import ru.gb.models.Task;
import ru.gb.models.TaskStatus;
import ru.gb.services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/main-app")
public class TaskController {

    /**
     * Сервис обработки задач
     */
    private final TaskService service;


    public TaskController(TaskService service) {
        this.service = service;
    }

    /**
     * Добавление задачи
     * @param task задача
     * @return задача
     */
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return service.addTask(task);
    }

    /**
     * Получение всех задач
     * @return лист задач
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    /**
     * Получение списка задач по статусу
     * @param status статус
     * @return лист задач
     */
    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus(@PathVariable TaskStatus status) {
        return service.getTaskByStatus(status);
    }

    /**
     * Обновление задачи
     * @param task обновленная задача
     * @return задача
     */
    @PutMapping()
    public Task updateTaskStatus(@RequestBody Task task) {
        return service.updateTaskStatus(task);
    }

    /**
     * Удаление задачи
     * @param id идентификатор задачи
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }
}
