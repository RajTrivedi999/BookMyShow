package com.example.bookMyShow_R.Dto.ResponseDto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowResponseDto {

    private int id;
    private LocalDate showDate;
    private LocalTime showTime;
    private MovieResponseDto movieResponseDto;
    private TheatreResponseDto theatreResponseDto;
}
