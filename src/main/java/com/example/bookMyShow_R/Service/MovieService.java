package com.example.bookMyShow_R.Service;

import com.example.bookMyShow_R.Dto.EntryDto.MovieEntryDto;
import com.example.bookMyShow_R.Dto.ResponseDto.MovieNameAndIdObject;
import com.example.bookMyShow_R.Dto.ResponseDto.MovieResponseDto;

public interface MovieService {

    //add
    public MovieResponseDto addMovie(MovieEntryDto movieDto);

    //
    public MovieNameAndIdObject getNameAndId(int id);

    //get
    public MovieResponseDto getMovie(int id);
}
