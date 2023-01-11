package com.example.bookMyShow_R.Service;

import com.example.bookMyShow_R.Dto.EntryDto.UserEntryDto;
import com.example.bookMyShow_R.Dto.ResponseDto.UserResponseDto;

public interface UserService {

    //add
    public void addUser(UserEntryDto userDto);

    //get
    public UserResponseDto getUser(int id);
}