package com.example.bookMyShow_R.Service;

import com.example.bookMyShow_R.Dto.BookTicketRequestDto;
import com.example.bookMyShow_R.Dto.ResponseDto.TicketResponseDto;

public interface TicketService {

    public TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto);

    public TicketResponseDto getTicket(int id);
}
