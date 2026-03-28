package com.cafe.adda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cafe.adda.entities.DailySales;
import com.cafe.adda.repository.DailySalesRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/daily-sales")
@CrossOrigin
public class DailySalesController {

    @Autowired
    private DailySalesRepository dailySalesRepo;

    // Retrieve sales for a given date (format: yyyy-MM-dd)
    @GetMapping("/{date}")
    public ResponseEntity<Integer> getSalesByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        Optional<DailySales> dailySales = dailySalesRepo.findByDate(date);
        if (dailySales.isPresent()) {
            return ResponseEntity.ok(dailySales.get().getTotalAmount());
        } else {
            return ResponseEntity.ok(0); // No sales found for this date
        }
    }
    
    @GetMapping("/range")
    public List<DailySales> getSalesInRange(
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return dailySalesRepo.findAll()
                             .stream()
                             .filter(ds -> !ds.getDate().isBefore(start) && !ds.getDate().isAfter(end))
                             .collect(Collectors.toList());
    }

}