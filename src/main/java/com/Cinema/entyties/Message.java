package com.Cinema.entyties;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mess_generator")
    @SequenceGenerator(name = "mess_generator", sequenceName = "mess_seq", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cookie_id")
    private User from;

    @NonNull
    @Column(name = "text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id")
    private Film film;

    public Message(User from, String text, Film film) {
        this.from = from;
        this.text = text;
        this.film = film;
    }
}
