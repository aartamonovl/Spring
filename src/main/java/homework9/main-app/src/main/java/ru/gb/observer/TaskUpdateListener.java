package ru.gb.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.gb.services.FileGateway;

@Component
public class TaskUpdateListener implements ApplicationListener<AddTaskEvent> {
    @Autowired
    FileGateway fileGateway;

    /**
     * Запись в файл по событию
     *
     * @param event событие
     */
    @Override
    public void onApplicationEvent(AddTaskEvent event) {
        fileGateway.writeToFile("all_tasks.txt", event.getTask());
        System.out.println("ok");
    }
}
