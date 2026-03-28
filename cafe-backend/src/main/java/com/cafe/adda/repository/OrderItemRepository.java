package com.cafe.adda.repository;

import java.security.Timestamp;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe.adda.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByServedFalseOrderByCreatedAtAsc();
//    List<OrderItem> findAllByCreatedAtBetween(java.sql.Timestamp start, java.sql.Timestamp end);
	Collection<OrderItem> findAllByCreatedAtBetween(java.sql.Timestamp start, java.sql.Timestamp end);
}
