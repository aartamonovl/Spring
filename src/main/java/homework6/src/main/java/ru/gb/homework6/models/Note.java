package ru.gb.homework6.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Note {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Заголовок
     */
    @Column(nullable = false)
    private String header;

    /**
     * Содержание
     */
    @Column(nullable = false)
    private String content;

    /**
     * Дата создания
     */
    private LocalDateTime createDate;
}
