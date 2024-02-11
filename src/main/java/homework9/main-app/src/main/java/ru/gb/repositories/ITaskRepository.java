package ru.gb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.models.Task;
import ru.gb.models.TaskStatus;

import java.util.List;

public interface ITaskRepository extends JpaRepository<Task, Long> {


    List<Task> findTasksByStatus(TaskStatus status);
}
