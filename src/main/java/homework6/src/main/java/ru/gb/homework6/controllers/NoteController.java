package ru.gb.homework6.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.homework6.models.Note;
import ru.gb.homework6.services.NoteService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    /**
     * Сервис
     */
    private final NoteService noteService;

    /**
     * Просмотр всех заметок
     *
     * @return результат обработки запроса
     */
    @GetMapping
    public ResponseEntity<List<Note>> getAll() {
        return new ResponseEntity<>(noteService.getAllNote(), HttpStatus.OK);
    }

    /**
     * Добавление заметки
     *
     * @param note новая заметка
     * @return результат обработки запроса
     */
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.CREATED);
    }

    /**
     * Получение заметки по id
     *
     * @param id идентификатор заметки
     * @return результат обработки запроса
     */
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable("id") Long id) {
        Note note;
        try {
            note = noteService.getNoteById(id);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    /**
     * Редактирование заметки
     *
     * @param note обновленная заметки
     * @return результат обработки запроса
     */
    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.updateNote(note), HttpStatus.OK);
    }

    /**
     * Удаление заметки
     *
     * @param id идентификатор заметки
     * @return результат обработки запроса
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable("id") Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }
}
