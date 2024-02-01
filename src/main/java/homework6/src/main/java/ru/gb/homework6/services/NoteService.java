package ru.gb.homework6.services;

import org.springframework.stereotype.Service;
import ru.gb.homework6.models.Note;

import java.util.List;
import java.util.Optional;

@Service
public interface NoteService {

    /**
     * Просмотр всех заметок
     *
     * @return список записок
     */
    List<Note> getAllNote();

    /**
     * Получение заметки по id
     *
     * @return заметка
     */
    Note getNoteById(Long id);

    /**
     * Редактирование заметки по id
     *
     * @return заметка
     */
    Note updateNote(Note note);

    /**
     * Добавление заметки
     *
     * @return заметка
     */
    Note createNote(Note note);

    /**
     * Удаление заметки
     * Добавление заметки
     */
    void deleteNote(Long id);
}
