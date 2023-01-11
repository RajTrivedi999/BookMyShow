package com.example.bookMyShow_R.Controller;

import com.example.bookMyShow_R.Dto.EntryDto.MovieEntryDto;
import com.example.bookMyShow_R.Dto.ResponseDto.MovieResponseDto;
import com.example.bookMyShow_R.Service.Impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    MovieServiceImpl movieService;

    @PostMapping("/add")
    public MovieResponseDto addShow(@RequestBody() MovieEntryDto movieEntryDto){
        return movieService.addMovie(movieEntryDto);
    }

    @GetMapping("get/{id}")
    public MovieResponseDto getShow(@PathVariable Integer id){
        return movieService.getMovie(id);
    }
}
