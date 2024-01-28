package ru.gb.homework4.services;

import org.springframework.stereotype.Service;
import ru.gb.homework4.models.User;
import ru.gb.homework4.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    /**
     * Репозиторий
     */
    private UserRepository userRepository;

    /**
     * Конструктор
     * @param userRepository репозиторий
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Запрос в репозиторий на получение списка всех пользователей
     * @return список всех пользователей
     */
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    /**
     * Добавление пользователя
     * @param user созданный пользователь
     * @return пользователь
     */
    public User addUser(User user) {
        userRepository.addUser(user);
        return user;
    }

}
