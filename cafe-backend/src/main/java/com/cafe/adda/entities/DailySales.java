package com.cafe.adda.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "daily_sales")
public class DailySales {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, unique = true)
	    private LocalDate date;

	    @Column(nullable = false)
	    private Integer totalAmount;  // total sales in ₹ for that day

	    // Constructors
	    public DailySales() {}

	    public DailySales(LocalDate date, Integer totalAmount) {
	        this.date = date;
	        this.totalAmount = totalAmount;
	    }

	    // Getters and Setters
	    
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public LocalDate getDate() { return date; }
	    public void setDate(LocalDate date) { this.date = date; }

	    public Integer getTotalAmount() { return totalAmount; }
	    public void setTotalAmount(Integer totalAmount) { this.totalAmount = totalAmount; }

    
}
