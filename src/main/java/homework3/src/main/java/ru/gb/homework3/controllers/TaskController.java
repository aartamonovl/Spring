package ru.gb.homework3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.homework3.domain.User;
import ru.gb.homework3.services.DataProcessingService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    /**
     * Метод, хранящий возможные действия над списком пользователей
     *
     * @return Список возможных действий
     */
    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    /**
     * Вызов сортировки пользователей по ссылке /sort
     *
     * @return Отсортированный список пользователей
     */

    @GetMapping("/sort")
    public List<User> sortUsersByAge() {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    /**
     * Вызов фильтрации пользователей по возрасту по ссылке /filter/{age}
     *
     * @return Отфильтрованный список пользователей
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable("age") int age) {
        return service.filterUsersByAge(service.getRepository().getUsers(), age);
    }

    /**
     * Вызов нахождение среднего возраста пользователей по ссылке /calc
     *
     * @return Средний возраст пользователей
     */
    @GetMapping("/calc")
    public double calculateAverageAge() {
        return service.calculateAverageAge(service.getRepository().getUsers());
    }
}
