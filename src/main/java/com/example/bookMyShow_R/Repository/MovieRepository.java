package com.example.bookMyShow_R.Repository;

import com.example.bookMyShow_R.Modle.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    boolean existsByName(String name);
}
