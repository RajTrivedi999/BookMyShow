package com.example.bookMyShow_R.Modle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "release_date",nullable = false)
    private LocalDate releaseDate;

    @OneToMany(mappedBy = "movies",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Show> shows;
}
