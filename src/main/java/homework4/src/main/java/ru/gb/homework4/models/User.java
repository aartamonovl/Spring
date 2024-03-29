package ru.gb.homework4.models;

import org.springframework.stereotype.Component;

@Component
public class User {
    /**
     * Имя
     */
    private String name;
    /**
     * Фамилия
     */
    private String lastName;
    /**
     * Возраст
     */
    private int age;

    public User() {
    }

    public User(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
