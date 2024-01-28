package ru.gb.homework5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.homework5.models.Task;
import ru.gb.homework5.models.TaskStatus;

import java.util.List;

public interface ITaskRepository extends JpaRepository<Task, Long> {


    List<Task> findTasksByStatus(TaskStatus status);
}
