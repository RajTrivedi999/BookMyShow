package com.example.bookMyShow_R.Service;

import com.example.bookMyShow_R.Dto.EntryDto.ShowEntryDto;
import com.example.bookMyShow_R.Dto.ResponseDto.ShowResponseDto;

public interface ShowService {

    public ShowResponseDto addShow(ShowEntryDto showDto);

    public ShowResponseDto getShow(int id);
}
