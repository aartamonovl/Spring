package ru.gb.homework3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.homework3.domain.User;
import ru.gb.homework3.services.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    /**
     * Добавление пользователя из тела запроса
     *
     * @param user сформированный пользователь
     * @return Ответное сообщение на запрос
     */
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        service.processRegistration(user);
        return "User added from body!";
    }

    /**
     * Добавление пользователя из параметров запроса
     *
     * @param name  имя пользователя
     * @param age   возраст
     * @param email почта
     * @return Ответное сообщение на запрос
     */
    @PostMapping("/param")
    public String userAddFromParam(@RequestParam("name") String name
            , @RequestParam("age") int age
            , @RequestParam("email") String email) {
        service.processRegistration(name, age, email);
        return "User added from http param";
    }
}
