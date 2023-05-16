package com.Cinema.repositories;

import com.Cinema.entyties.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallsRepository extends JpaRepository<Hall, Integer> {

}
