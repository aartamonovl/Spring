package ru.gb.homework3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.homework3.domain.User;
import ru.gb.homework3.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    @Autowired
    private UserRepository repository;

    /**
     * Сортировка списка пользователей по возрасту по возрастанию
     * @param users список пользователей
     * @return отсортированный список пользователей
     */
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Фильтрация списка пользователей по возрасту
     * @param users список пользователей
     * @param age возраст, ограничивающий снизу список
     * @return список пользователей с возрастом больше age
     */
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Вычисление среднего возраста пользователей
     * @param users список пользователей
     * @return число в формате double, средний возраст
     */
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    public UserRepository getRepository() {
        return repository;
    }

}
