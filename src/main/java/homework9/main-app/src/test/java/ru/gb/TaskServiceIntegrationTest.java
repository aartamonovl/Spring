package ru.gb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.gb.models.Task;
import ru.gb.models.TaskStatus;
import ru.gb.repositories.ITaskRepository;
import ru.gb.services.TaskService;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class TaskServiceIntegrationTest {
    @MockBean
    public ITaskRepository repository;

    @Autowired
    public TaskService service;

    @Test
    void addTaskGoodTest() {
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
