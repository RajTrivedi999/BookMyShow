package com.example.bookMyShow_R.Dto.ResponseDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieNameAndIdObject {
    int id;

    String name;
}
