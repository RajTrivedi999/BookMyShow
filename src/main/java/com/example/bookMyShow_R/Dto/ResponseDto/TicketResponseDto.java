package com.example.bookMyShow_R.Dto.ResponseDto;

import com.example.bookMyShow_R.Dto.ResponseDto.ShowResponseDto;
import com.example.bookMyShow_R.Dto.ResponseDto.UserResponseDto;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class TicketResponseDto {
    int id;
    double amount;
    String allottedSeats;
}
