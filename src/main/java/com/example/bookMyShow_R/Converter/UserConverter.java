package com.example.bookMyShow_R.Converter;

import com.example.bookMyShow_R.Dto.EntryDto.UserEntryDto;
import com.example.bookMyShow_R.Dto.ResponseDto.UserResponseDto;
import com.example.bookMyShow_R.Modle.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {

    public static User dtoToEntity(UserEntryDto userDto){
        return User.builder().name(userDto.getName()).mobile(userDto.getMobile()).build();
    }

    public static UserResponseDto entityToDto(User user){
        return UserResponseDto.builder().id(user.getId()).name(user.getName()).mobile(user.getMobile()).build();
    }
}