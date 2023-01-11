package com.example.bookMyShow_R.Dto.ResponseDto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponseDto {

    private int id;
    private String name;
    private LocalDate releaseDate;
    private List<ShowResponseDto> showDtos;

}
