package com.example.demo.repository;

import com.example.demo.entities.FilghtSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilghtRepository extends JpaRepository<FilghtSchedule, Integer> {

}
