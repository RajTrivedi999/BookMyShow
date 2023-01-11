package com.example.bookMyShow_R.Controller;

import com.example.bookMyShow_R.Dto.EntryDto.UserEntryDto;
import com.example.bookMyShow_R.Dto.ResponseDto.UserResponseDto;
import com.example.bookMyShow_R.Service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("add")
    public ResponseEntity addUser(@RequestBody UserEntryDto userEntryDto){
        userService.addUser(userEntryDto);
        return new ResponseEntity("Added a success User", HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponseDto> gerUser(@PathVariable(value = "id")int id){
        UserResponseDto userResponseDto=userService.getUser(id);
        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }
}
