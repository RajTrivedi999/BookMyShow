package com.example.bookMyShow_R.Service.Impl;

import com.example.bookMyShow_R.Converter.ShowConverter;
import com.example.bookMyShow_R.Dto.EntryDto.ShowEntryDto;
import com.example.bookMyShow_R.Dto.ResponseDto.ShowResponseDto;
import com.example.bookMyShow_R.Modle.*;
import com.example.bookMyShow_R.Repository.MovieRepository;
import com.example.bookMyShow_R.Repository.ShowRepository;
import com.example.bookMyShow_R.Repository.ShowSeatsRepository;
import com.example.bookMyShow_R.Repository.TheatreRepository;
import com.example.bookMyShow_R.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Override
    public ShowResponseDto addShow(ShowEntryDto showDto) {
        Show show=ShowConverter.dtoToEntity(showDto);

        Movie movie=movieRepository.findById(showDto.getMovieResponseDto().getId()).get();
        show.setMovies(movie);

        Theatre theatre=theatreRepository.findById(showDto.getTheatreResponseDto().getId()).get();
        show.setTheatre(theatre);

        show=showRepository.save(show);
        List<ShowSeats> showSeats=createShowSeats(theatre.getTheatreSeats(),show);
        showSeatsRepository.saveAll(showSeats);

        //show.setShowSeats(showSeats);

        ShowResponseDto showResponseDto=ShowConverter.entityToDto(show,showDto);
        return showResponseDto;
    }

    public List<ShowSeats> createShowSeats(List<TheatreSeat> theatreSeat,Show show){
        List<ShowSeats> showSeats=new ArrayList<>();

        for(TheatreSeat seat : theatreSeat){
            ShowSeats showSeat = ShowSeats.builder().
                    seatNumber(seat.getSeatNumber()).
                    rate(seat.getRate()).
                    seatType(seat.getSeatType()).
                    build();

            showSeats.add(showSeat);
        }

        for(ShowSeats seats : showSeats){
            seats.setShow(show);
        }
        show.setShowSeats(showSeats);
        return showSeats;
    }

    @Override
    public ShowResponseDto getShow(int id) {
        Show show= showRepository.findById(id).get();
        return ShowConverter.entityToDto(show);
    }
}
