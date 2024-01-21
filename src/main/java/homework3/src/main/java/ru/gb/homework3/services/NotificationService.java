package ru.gb.homework3.services;

import org.springframework.stereotype.Service;
import ru.gb.homework3.domain.User;

@Service
public class NotificationService {
    /**
     * Сообщение в консоль об успешном создании нового пользователя
     * @param user пользователь
     */
    public void notifyUser(User user){
        System.out.println("A new user been created: " + user.getName());
    }

    /**
     * Сообщение в консоль об успешном добавлении нового пользователя в базу данных
     * @param user пользователь
     */
    public void addUserToRepository(User user){
        System.out.println("A new user been added to repository: " + user.getName());
    }
}