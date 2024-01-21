package ru.gb.homework3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.homework3.domain.User;

@Service
public class RegistrationService {

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private DataProcessingService dataProcessingService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public UserService getUserService() {
        return userService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    /**
     * Регистрация нового пользователя
     * @param user пользователь
     */
    public void processRegistration(User user) {
        User userNew = userService.createUser(user.getName(), user.getAge(), user.getEmail());
        dataProcessingService.getRepository().save(userNew);
        notificationService.addUserToRepository(userNew);
    }

    /**
     * Создание нового пользователя
     * @param name имя
     * @param age возраст
     * @param email почта
     */
    public void processRegistration(String name, int age, String email){
        User userNew = userService.createUser(name, age, email);
        dataProcessingService.getRepository().save(userNew);
        notificationService.addUserToRepository(userNew);
    }
}
