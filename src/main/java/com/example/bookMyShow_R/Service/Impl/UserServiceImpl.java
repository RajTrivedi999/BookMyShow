package com.example.bookMyShow_R.Service.Impl;

import com.example.bookMyShow_R.Converter.UserConverter;
import com.example.bookMyShow_R.Dto.EntryDto.UserEntryDto;
import com.example.bookMyShow_R.Dto.ResponseDto.UserResponseDto;
import com.example.bookMyShow_R.Modle.User;
import com.example.bookMyShow_R.Repository.UserRepository;
import com.example.bookMyShow_R.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(UserEntryDto userDto) {

        User user= UserConverter.dtoToEntity(userDto);
        userRepository.save(user);
    }

    @Override
    public UserResponseDto getUser(int id) {
        User user=userRepository.findById(id).get();
        UserResponseDto userDto=UserConverter.entityToDto(user);
        return userDto;
    }
}