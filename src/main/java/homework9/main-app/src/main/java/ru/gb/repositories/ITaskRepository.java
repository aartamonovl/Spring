package ru.gb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.models.Task;
import ru.gb.models.TaskStatus;

import java.util.List;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {

    /**
     * Получение всех задач по статусу
     * @param status статус
     * @return лист задач
     */
    List<Task> findTasksByStatus(TaskStatus status);
}
