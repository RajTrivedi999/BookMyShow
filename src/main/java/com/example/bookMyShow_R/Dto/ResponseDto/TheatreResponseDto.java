package com.example.bookMyShow_R.Dto.ResponseDto;

import com.example.bookMyShow_R.Enums.TheatreType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheatreResponseDto {

    private int id;
    private String name;
    private String city;
    private String address;
    private TheatreType type;

}
