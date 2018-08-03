package com.example.demo.repository;

import com.example.demo.entities.RefClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefClassRepository extends JpaRepository<RefClass, Integer> {
}
