package com.Cinema.entyties;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "film")
public class Film {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "film_generator")
    @SequenceGenerator(name = "film_generator", sequenceName = "film_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Year")
    private String year;

    @Column(name = "Description", columnDefinition = "text")
    private String description;

    @Column(name = "Image")
    private String image;

    public Film(String title, String year, String description, String image)
    {
        this.title = title;
        this.year = year;
        this.description = description;
        this.image = image;
    }
}
