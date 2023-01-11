package com.example.bookMyShow_R.Converter;

import com.example.bookMyShow_R.Dto.ResponseDto.TicketResponseDto;
import com.example.bookMyShow_R.Modle.Ticket;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TicketConverter {

    public static TicketResponseDto entityToDto(Ticket ticket){
        return TicketResponseDto.builder().id(ticket.getId()).amount(ticket.getAmount()).allottedSeats(ticket.getAllottedSeat()).build();
    }
}
