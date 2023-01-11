package com.example.bookMyShow_R.Service.Impl;

import com.example.bookMyShow_R.Converter.MovieConverter;
import com.example.bookMyShow_R.Dto.EntryDto.MovieEntryDto;
import com.example.bookMyShow_R.Dto.ResponseDto.MovieNameAndIdObject;
import com.example.bookMyShow_R.Dto.ResponseDto.MovieResponseDto;
import com.example.bookMyShow_R.Modle.Movie;
import com.example.bookMyShow_R.Repository.MovieRepository;
import com.example.bookMyShow_R.Service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieResponseDto addMovie(MovieEntryDto movieDto) {

        MovieResponseDto movieResponseDto=null;

        if(movieRepository.existsByName(movieDto.getName())){
            movieResponseDto.setName("This Movie Is Already Existing");
            return movieResponseDto;
        }

        log.info("Reached addMovie function");

        Movie movie= MovieConverter.dtoToEntity(movieDto);
        movie= movieRepository.save(movie);

        movieResponseDto= MovieConverter.entityToDto(movie);

        return movieResponseDto;
    }

    public  MovieResponseDto getMovie(int id){
        Movie movie=movieRepository.findById(id).get();
        MovieResponseDto movieResponseDto=MovieConverter.entityToDto(movie);
        return  movieResponseDto;
    }

    @Override
    public MovieNameAndIdObject getNameAndId(int id) {
        Movie movie=movieRepository.findById(id).get();
        MovieNameAndIdObject obj=MovieConverter.entityToObj(movie);
        return obj;
    }
}
