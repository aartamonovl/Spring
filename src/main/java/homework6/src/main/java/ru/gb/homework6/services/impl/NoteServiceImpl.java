package ru.gb.homework6.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.homework6.models.Note;
import ru.gb.homework6.repositories.NoteRepository;
import ru.gb.homework6.services.NoteService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    /**
     * Репозиторий
     */
    private final NoteRepository noteRepository;

    /**
     * Просмотр всех заметок
     *
     * @return список записок
     */
    @Override
    public List<Note> getAllNote() {
        return noteRepository.findAll();
    }

    /**
     * Получение заметки по id
     *
     * @param id
     * @return заметка
     */
    @Override
    public Note getNoteById(Long id) {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isPresent()){
            return note.get();
        }
        return new Note();
    }

    /**
     * Редактирование заметки по id
     *
     * @param note
     * @return заметка
     */
    @Override
    public Note updateNote(Note note) {
        Note noteFound = getNoteById(note.getId());

        noteFound.setHeader(note.getHeader());
        noteFound.setContent(note.getContent());

        return noteRepository.save(noteFound);
    }

    /**
     * Добавление заметки
     *
     * @param note
     * @return заметка
     */
    @Override
    public Note createNote(Note note) {

        note.setCreateDate(LocalDateTime.now());
        return noteRepository.save(note);
    }

    /**
     * Удаление заметки
     * Добавление заметки
     *
     * @param id
     */
    @Override
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
