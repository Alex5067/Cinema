package com.Cinema.entyties;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "hall")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hall_generator")
    @SequenceGenerator(name = "hall_generator", sequenceName = "hall_seq", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @NonNull
    @Column(name = "seats")
    private String seats;
}
