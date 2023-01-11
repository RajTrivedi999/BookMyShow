package com.example.bookMyShow_R.Controller;

import com.example.bookMyShow_R.Dto.BookTicketRequestDto;
import com.example.bookMyShow_R.Dto.ResponseDto.TicketResponseDto;
import com.example.bookMyShow_R.Repository.TicketRepository;
import com.example.bookMyShow_R.Service.Impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    TicketServiceImpl ticketService;

    @PostMapping("/add")
    public TicketResponseDto addTicket(@RequestBody() BookTicketRequestDto bookTicketRequestDto){
        return ticketService.bookTicket(bookTicketRequestDto);
    }

    @GetMapping("get/{id}")
    public TicketResponseDto getTicket(@PathVariable Integer id){
        return  ticketService.getTicket(id);
    }
}
