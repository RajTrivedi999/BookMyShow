package com.example.bookMyShow_R.Controller;

import com.example.bookMyShow_R.Dto.EntryDto.ShowEntryDto;
import com.example.bookMyShow_R.Dto.ResponseDto.ShowResponseDto;
import com.example.bookMyShow_R.Service.Impl.ShowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("show")
public class ShowController {
    @Autowired
    ShowServiceImpl showService;

    @PostMapping("/add")
    public ShowResponseDto addShow(@RequestBody()ShowEntryDto showEntryDto){
        return showService.addShow(showEntryDto);
    }

    @GetMapping("get/{id}")
    public ShowResponseDto getShow(@PathVariable Integer id){
        return showService.getShow(id);
    }
}
