package com.example.bookMyShow_R.Modle;

import com.example.bookMyShow_R.Enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "show_seats")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowSeats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "rate",nullable = false)
    private int rate;

    @Column(name = "seat_number",nullable = false)
    private String seatNumber;

    @Column(name = "booked",columnDefinition = "bit(1) default 0",nullable = false)
    private boolean booked;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booked_at")
    private Date bookedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type",nullable = false)
    private SeatType seatType;

    @ManyToOne
    @JsonIgnore
    private Ticket ticket;

    @ManyToOne
    @JsonIgnore
    private Show show;
}
