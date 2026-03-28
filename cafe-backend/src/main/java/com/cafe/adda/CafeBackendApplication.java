package com.cafe.adda;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.cafe.adda.entities.MenuItem;
import com.cafe.adda.repository.MenuItemRepository;

@SpringBootApplication
@EnableScheduling
public class CafeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafeBackendApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner dataLoader(MenuItemRepository repo) {
	    return args -> {
	        if (repo.count() == 0) {
	            repo.save(new MenuItem("Special Veg Munch Roll", 40));
	            repo.save(new MenuItem("Special Veg Munch CHEESE Roll", 50));
	            repo.save(new MenuItem("Veg Masala Manchurian", 35));
	            repo.save(new MenuItem("Veg Manchurian Bhel", 35));
	            repo.save(new MenuItem("Chilax Cold Coffee", 40));
	            repo.save(new MenuItem("Chilax Cold COCOA", 40));
	            repo.save(new MenuItem("Veg Manchurian Paav", 25));
	            repo.save(new MenuItem("Veg Peri Peri Manchurian", 25));
	            repo.save(new MenuItem("Special DahiVada", 40));
	            repo.save(new MenuItem("Roll+Manchurian+Cold Cofee Platters", 99));
	        }
	    };
	}

}
