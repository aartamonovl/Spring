package ru.gb.observer;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.gb.models.Task;

@Getter
public class AddTaskEvent extends ApplicationEvent {

    private Task task;

    public AddTaskEvent(Object source, Task task) {
        super(source);
        this.task = task;
    }
}
