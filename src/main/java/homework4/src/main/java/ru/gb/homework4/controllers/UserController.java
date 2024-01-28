package ru.gb.homework4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.homework4.models.User;
import ru.gb.homework4.services.UserService;

@Controller
public class UserController {

    private UserService userService;

    /**
     *
     * @param userService - бизнес-слой
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Обработка запроса на страничке Все пользователи
     * @param model для передачи параметров
     * @return представление users.html
     */
    @RequestMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users.html";
    }

    /**
     * Переход на страничку создания пользователя
     * @param model для передачи параметров
     * @return представление add.html
     */
    @GetMapping("/add")
    public String addUserForm(Model model){
        model.addAttribute("user", new User());
        return "add.html";
    }

    /**
     * Обработка запроса на создание пользователя
     * @param user пользователь
     * @param model для передачи параметров
     * @return представление users.html
     */
    @PostMapping("/add")
    public String addUser(User user, Model model){
        userService.addUser(user);
        model.addAttribute("users", userService.getAllUsers());
        return "users.html";
    }
}
