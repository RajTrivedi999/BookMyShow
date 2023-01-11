package com.example.bookMyShow_R.Dto;

import com.example.bookMyShow_R.Dto.ResponseDto.ShowResponseDto;
import com.example.bookMyShow_R.Dto.ResponseDto.UserResponseDto;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class TicketDto {
    int id;
    double amount;
    Set<String> allottedSeats;

    ShowResponseDto showDto;
    UserResponseDto userDto;
}
