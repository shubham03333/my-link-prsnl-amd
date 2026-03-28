package com.cafe.adda;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cafe.adda.entities.DailySales;
import com.cafe.adda.entities.OrderItem;
import com.cafe.adda.repository.DailySalesRepository;
import com.cafe.adda.repository.OrderItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DailySalesScheduler {

    @Autowired
    private OrderItemRepository orderRepo;

    @Autowired
    private DailySalesRepository dailySalesRepo;

    // Runs every day at 12:00 AM IST
    @Scheduled(cron = "0 0 0 * * *", zone = "Asia/Kolkata")
    public void archiveDailySales() {
        LocalDate yesterday = LocalDate.now(ZoneId.of("Asia/Kolkata")).minusDays(1);
        Timestamp start = Timestamp.valueOf(yesterday.atStartOfDay());
        Timestamp end = Timestamp.valueOf(yesterday.plusDays(1).atStartOfDay());

        // Fetch served orders created between start and end timestamps
        List<OrderItem> orders = orderRepo.findAllByCreatedAtBetween(start, end)
                .stream()
                .filter(OrderItem::getServed)
                .collect(Collectors.toList());

        int total = orders.stream()
                .mapToInt(o -> o.getMenuItem().getPrice())
                .sum();

        // Save or update daily sales record for yesterday
        dailySalesRepo.findByDate(yesterday).ifPresentOrElse(existing -> {
            existing.setTotalAmount(total);
            dailySalesRepo.save(existing);
        }, () -> {
            DailySales dailySales = new DailySales(yesterday, total);
            dailySalesRepo.save(dailySales);
        });
    }
}