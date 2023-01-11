package com.example.bookMyShow_R.Repository;

import com.example.bookMyShow_R.Modle.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
