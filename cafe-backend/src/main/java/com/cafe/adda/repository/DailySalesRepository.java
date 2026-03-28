package com.cafe.adda.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe.adda.entities.DailySales;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.Optional;

public interface DailySalesRepository extends JpaRepository<DailySales, Long> {
    Optional<DailySales> findByDate(LocalDate date);
    List<DailySales> findAllByDateBetween(LocalDate start, LocalDate end);

}