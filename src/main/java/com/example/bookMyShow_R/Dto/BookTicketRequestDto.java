package com.example.bookMyShow_R.Dto;

import com.example.bookMyShow_R.Enums.SeatType;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookTicketRequestDto {

    int id;
    int showId;
    SeatType seatType;
    Set<String> requestedSeats;

}
