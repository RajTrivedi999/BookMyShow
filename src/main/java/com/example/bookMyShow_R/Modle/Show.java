package com.example.bookMyShow_R.Modle;

import com.example.bookMyShow_R.Dto.ResponseDto.MovieResponseDto;
import com.example.bookMyShow_R.Dto.ResponseDto.TheatreResponseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "shows")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "show_date",nullable = false)
    private LocalDate showDate;

    @Column(name = "show_time",nullable = false)
    private LocalTime showTime;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at")
    private Date createAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_at")
    private Date updateAt;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Ticket> tickets;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    @JsonIgnore
    List<ShowSeats> showSeats;

    @ManyToOne
    @JoinColumn
    Movie movies;

    @ManyToOne
    @JoinColumn
    Theatre theatre;
}
