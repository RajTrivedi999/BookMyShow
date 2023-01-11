package com.example.bookMyShow_R.Dto.EntryDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;

@Builder
@Getter
public class MovieEntryDto {

    String name;

    @NonNull
    LocalDate releaseDate;
}
