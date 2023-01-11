package com.example.bookMyShow_R.Service.Impl;

import com.example.bookMyShow_R.Converter.TicketConverter;
import com.example.bookMyShow_R.Dto.BookTicketRequestDto;
import com.example.bookMyShow_R.Dto.ResponseDto.TicketResponseDto;
import com.example.bookMyShow_R.Enums.SeatType;
import com.example.bookMyShow_R.Modle.Show;
import com.example.bookMyShow_R.Modle.ShowSeats;
import com.example.bookMyShow_R.Modle.Ticket;
import com.example.bookMyShow_R.Modle.User;
import com.example.bookMyShow_R.Repository.ShowRepository;
import com.example.bookMyShow_R.Repository.TicketRepository;
import com.example.bookMyShow_R.Repository.UserRepository;
import com.example.bookMyShow_R.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {

        User user=userRepository.findById(bookTicketRequestDto.getId()).get();
        Show show=showRepository.findById(bookTicketRequestDto.getShowId()).get();

        //SeatType seatType= bookTicketRequestDto.getSeatType();

        Set<String> requestedSeats = bookTicketRequestDto.getRequestedSeats();

        List<ShowSeats> showSeatsList=show.getShowSeats();
        //Set<String> allottedSeats;

        List<ShowSeats> bookedSeats =new ArrayList<>();
        for(ShowSeats seats : showSeatsList){
            if(!seats.isBooked() && seats.getSeatType().equals(bookTicketRequestDto.getSeatType()) && requestedSeats.contains(seats.getSeatNumber())){
                bookedSeats.add(seats);
            }
        }

        for(ShowSeats seats : bookedSeats) System.out.println(seats);
        if(bookedSeats.size()!=requestedSeats.size()){
            throw new Error("All Seats Not Available");
        }

        Ticket ticket=Ticket.builder().
                user(user).
                show(show).
                showSeats(bookedSeats).
                build();

        int amount=0;

        for(ShowSeats seat : bookedSeats){
            seat.setBooked(true);
            seat.setBookedAt(new Date());
            seat.setTicket(ticket);

            amount += seat.getRate();
        }
        ticket.setAmount(amount);
        ticket.setAllottedSeat(convertListOfSeatsToString(bookedSeats));
        ticket.setBookedAt(new Date());

        show.getTickets().add(ticket);

        user.getTicketList().add(ticket);
        ticket=ticketRepository.save(ticket);

        return TicketConverter.entityToDto(ticket);
    }

    public String convertListOfSeatsToString(List<ShowSeats> bookedSeats){
        String str="";
        for(ShowSeats seats : bookedSeats) {
            str = str + seats.getSeatNumber()+" ";
        }
        return str;
    }

    @Override
    public TicketResponseDto getTicket(int id) {
        Ticket ticket= ticketRepository.findById(id).get();
        TicketResponseDto ticketDto= TicketConverter.entityToDto(ticket);
        return ticketDto;
    }
}
