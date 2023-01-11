package com.example.bookMyShow_R.Service.Impl;

import com.example.bookMyShow_R.Converter.TheatreConverter;
import com.example.bookMyShow_R.Dto.EntryDto.TheatreEntryDto;
import com.example.bookMyShow_R.Dto.ResponseDto.TheatreResponseDto;
import com.example.bookMyShow_R.Enums.SeatType;
import com.example.bookMyShow_R.Enums.TheatreType;
import com.example.bookMyShow_R.Modle.Theatre;
import com.example.bookMyShow_R.Modle.TheatreSeat;
import com.example.bookMyShow_R.Repository.TheatreRepository;
import com.example.bookMyShow_R.Repository.TheatreSeatRepository;
import com.example.bookMyShow_R.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    TheatreSeatRepository theatreSeatRepository;

    @Override
    public TheatreResponseDto addTheatre(TheatreEntryDto theatreDto) {
        Theatre theatre=TheatreConverter.dtoToEntity(theatreDto);

        List<TheatreSeat> theatreSeatList=createSeats();

        theatre.setTheatreSeats(theatreSeatList);

        theatre.setShows(null);

        for (TheatreSeat theatreSeat : theatreSeatList){
            theatreSeat.setTheatre(theatre);
        }

        //theatre.setType(TheatreType.SINGLE);

        theatre=theatreRepository.save(theatre);

        theatreSeatRepository.saveAll(theatreSeatList);

        TheatreResponseDto theatreResponseDto=TheatreConverter.entityToDto(theatre);

        return theatreResponseDto;
    }

    public List<TheatreSeat> createSeats(){
        List<TheatreSeat> seats= new ArrayList<>();

        seats.add(getTheatreSeat("A1",100,SeatType.SILVER));
        seats.add(getTheatreSeat("A2",100,SeatType.SILVER));
        seats.add(getTheatreSeat("A3",100,SeatType.SILVER));
        seats.add(getTheatreSeat("A4",100,SeatType.SILVER));
        seats.add(getTheatreSeat("A5",100,SeatType.SILVER));

        seats.add(getTheatreSeat("B1",200,SeatType.GOLD));
        seats.add(getTheatreSeat("B2",200,SeatType.GOLD));
        seats.add(getTheatreSeat("B3",200,SeatType.GOLD));
        seats.add(getTheatreSeat("B4",200,SeatType.GOLD));
        seats.add(getTheatreSeat("B5",200,SeatType.GOLD));

        seats.add(getTheatreSeat("C1",300,SeatType.SOFA));
        seats.add(getTheatreSeat("C2",300,SeatType.SOFA));
        seats.add(getTheatreSeat("C3",300,SeatType.SOFA));
        seats.add(getTheatreSeat("C4",300,SeatType.SOFA));
        seats.add(getTheatreSeat("C5",300,SeatType.SOFA));

        return seats;
    }

    public TheatreSeat getTheatreSeat(String seatNo, int rate, SeatType seatType){
        return TheatreSeat.builder().seatNumber(seatNo).rate(rate).seatType(seatType).build();
    }

    @Override
    public TheatreResponseDto getTheatre(int id) {
        Theatre theatre=theatreRepository.findById(id).get();
        TheatreResponseDto theatreDto= TheatreConverter.entityToDto(theatre);
        return theatreDto;
    }
}