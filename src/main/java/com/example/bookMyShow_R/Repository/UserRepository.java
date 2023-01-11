package com.example.bookMyShow_R.Repository;

import com.example.bookMyShow_R.Modle.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}