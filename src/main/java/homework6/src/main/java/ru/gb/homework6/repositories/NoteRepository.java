package ru.gb.homework6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.homework6.models.Note;

import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    /**
     * Поиск заметки по id
     * @param id уникальный идентификатор заметки
     * @return объект Optional, хранящий значение, либо null
     */
    Optional<Note> findById(Long id);
}
