package com.example.bookMyShow_R.Dto.EntryDto;

import com.example.bookMyShow_R.Enums.TheatreType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheatreEntryDto {
    String name;
    String address;
    String city;
    TheatreType type;
}
