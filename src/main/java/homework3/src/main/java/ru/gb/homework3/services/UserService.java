package ru.gb.homework3.services;

import org.springframework.stereotype.Service;
import ru.gb.homework3.domain.User;

@Service
public class UserService {

    private NotificationService notificationService;

    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Создание нового пользователя
     *
     * @param name  имя
     * @param age   возраст
     * @param email почта
     * @return новый пользователь
     */
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        notificationService.notifyUser(user);

        return user;
    }
}
