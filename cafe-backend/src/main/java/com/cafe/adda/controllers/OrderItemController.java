package com.cafe.adda.controllers;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.adda.entities.MenuItem;
import com.cafe.adda.entities.OrderItem;
import com.cafe.adda.repository.MenuItemRepository;
import com.cafe.adda.repository.OrderItemRepository;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderItemController {
    @Autowired OrderItemRepository orderRepo;
    @Autowired MenuItemRepository menuRepo;

    @GetMapping("/queue")
    public List<OrderItem> getOrderQueue() {
        return orderRepo.findByServedFalseOrderByCreatedAtAsc();
    }

    @PostMapping("/add/{menuItemId}")
    public OrderItem addOrder(@PathVariable Long menuItemId) {
        MenuItem menuItem = menuRepo.findById(menuItemId).orElseThrow();
        OrderItem order = new OrderItem();
        order.setMenuItem(menuItem);
        order.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        order.setServed(false);
        return orderRepo.save(order);
    }

    @PatchMapping("/{orderId}/serve")
    public void serveOrder(@PathVariable Long orderId) {
        OrderItem order = orderRepo.findById(orderId).orElseThrow();
        order.setServed(true);
        orderRepo.save(order);
    }

    @GetMapping("/sales/today")
    public Integer getTodaySales() {
        LocalDate today = LocalDate.now();
        Timestamp start = Timestamp.valueOf(today.atStartOfDay());
        Timestamp end = Timestamp.valueOf(today.plusDays(1).atStartOfDay());
        List<OrderItem> orders = orderRepo.findAllByCreatedAtBetween(start, end)
                                          .stream().filter(OrderItem::getServed).collect(Collectors.toList());
        return orders.stream().mapToInt(o -> o.getMenuItem().getPrice()).sum();
    }
    
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> cancelOrder(@PathVariable Long orderId) {
        if (!orderRepo.existsById(orderId)) {
            return ResponseEntity.notFound().build();
        }
        orderRepo.deleteById(orderId);
        return ResponseEntity.noContent().build();
    }

}
