package com.example.bookMyShow_R.Service;

import com.example.bookMyShow_R.Dto.EntryDto.TheatreEntryDto;
import com.example.bookMyShow_R.Dto.ResponseDto.TheatreResponseDto;

public interface TheatreService {

    public TheatreResponseDto addTheatre(TheatreEntryDto theatreDto);

    public TheatreResponseDto getTheatre(int id);

}
