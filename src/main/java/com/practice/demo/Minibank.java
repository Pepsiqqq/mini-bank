package com.practice.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.Repository.customerRepository;
import com.practice.demo.Table.customer;

@SpringBootApplication
@RestController
public class Minibank {
    public static void main(String[] args) {
      SpringApplication.run(Minibank.class, args);
    }

	@Autowired
	customerRepository repository;

	void customerListAll() {
		for (customer Customer : repository.findAll()) {
			System.out.println(Customer);
		}
		//Iterable<customer> customers = repository.findAll();
	}
	
	@GetMapping("/customer")
	public void customerpage(){
		customerListAll();
	}
	
}