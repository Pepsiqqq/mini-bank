package com.practice.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.demo.Table.customer;

public interface customerRepository extends JpaRepository<customer, Long>{
    customer findById(long id);

}
