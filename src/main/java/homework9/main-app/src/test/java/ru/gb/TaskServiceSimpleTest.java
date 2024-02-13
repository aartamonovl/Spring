package ru.gb;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.gb.models.Task;
import ru.gb.models.TaskStatus;
import ru.gb.repositories.ITaskRepository;
import ru.gb.services.TaskService;

import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class TaskServiceSimpleTest {

    @Mock
    public ITaskRepository repository;

    @InjectMocks
    public TaskService service;

    @Test
    void addNewTaskGoodTest(){
        // pre
        Task task = new Task();
        task.setId(3L);
        task.setDescription("Task1");
        task.setStatus(TaskStatus.NOT_STARTED);
        given(repository.save(task)).willReturn(task);

        // action
        Task addedTask = service.addTask(task);

        // verify
        verify(repository).save(addedTask);
    }
}
