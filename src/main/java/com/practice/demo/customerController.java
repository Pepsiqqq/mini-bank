package com.practice.demo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.Repository.customerRepository;
import com.practice.demo.Table.customer;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class customerController {

    @Autowired
	customerRepository repository;

    @DeleteMapping("/customerRemove/{id}")
    public void removeCustomers(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PostMapping("/customerAdd")
    public void newCustomers(@RequestBody customer newCustomers){
        repository.save(newCustomers);
    }

    @GetMapping("/customerdata")
    public List<customer> getallCustomers(){
        List<customer> customers = repository.findAll(Sort.by(Sort.Direction.ASC, "iduser"));
        return customers;
    }
}
