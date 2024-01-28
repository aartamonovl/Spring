package ru.gb.homework4.repositories;

import org.springframework.stereotype.Repository;
import ru.gb.homework4.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository {

    /**
     * Имитация БД (Как в ДЗ к семинару 2)
     */
    List<User> users = new ArrayList<>(Arrays.asList(
            new User("A", "A", 25),
            new User("B", "B", 30),
            new User("C", "C", 35)
    ));

    public List<User> getAllUsers() {
        return users;
    }

    public User addUser(User user){
        users.add(user);
        return user;
    }
}
