package com.example.demo.repository;

import com.example.demo.entities.RefReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefReservationStatusRepository extends JpaRepository<RefReservationStatus, Integer> {
}
