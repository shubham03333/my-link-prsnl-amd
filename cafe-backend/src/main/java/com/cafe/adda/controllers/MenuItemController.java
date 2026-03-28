package com.cafe.adda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.adda.entities.MenuItem;
import com.cafe.adda.repository.MenuItemRepository;

@RestController
@RequestMapping("/api/menu")
@CrossOrigin
public class MenuItemController {
    @Autowired MenuItemRepository menuRepo;

    @GetMapping
    public List<MenuItem> getMenu() {
        return menuRepo.findAll();
    }
}
