package org.example.mvc_megainternet.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class Comment {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne ()
    @JoinColumn (name = "statement_id")
    private Statement statement;

    private LocalDateTime date;
    private String text;
}
