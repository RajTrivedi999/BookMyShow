package com.example.bookMyShow_R.Dto.EntryDto;

import com.example.bookMyShow_R.Dto.ResponseDto.MovieResponseDto;
import com.example.bookMyShow_R.Dto.ResponseDto.TheatreResponseDto;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ShowEntryDto {

    @NonNull
    LocalDate showDate;

    @NonNull
    LocalTime showTime;

    @NonNull
    MovieResponseDto movieResponseDto;

    @NonNull
    TheatreResponseDto theatreResponseDto;
}
