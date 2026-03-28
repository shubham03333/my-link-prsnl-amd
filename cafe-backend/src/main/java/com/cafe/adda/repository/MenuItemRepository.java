package com.cafe.adda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe.adda.entities.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {}
