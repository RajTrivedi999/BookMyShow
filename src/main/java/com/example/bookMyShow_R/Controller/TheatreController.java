package com.example.bookMyShow_R.Controller;

import com.example.bookMyShow_R.Dto.EntryDto.TheatreEntryDto;
import com.example.bookMyShow_R.Dto.ResponseDto.TheatreResponseDto;
import com.example.bookMyShow_R.Service.Impl.TheatreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theatre")
public class TheatreController {

    @Autowired
    TheatreServiceImpl theatreService;

    @PostMapping("add")
    public TheatreResponseDto addTheatre(@RequestBody()TheatreEntryDto theatreEntryDto){
        return theatreService.addTheatre(theatreEntryDto);
    }
}
