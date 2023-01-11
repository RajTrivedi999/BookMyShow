package com.example.bookMyShow_R.Dto.ResponseDto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {

    private int id;

    @NonNull
    private String name;

    @NonNull
    private String mobile;

    //Optional
    List<TicketResponseDto> tickets;
}