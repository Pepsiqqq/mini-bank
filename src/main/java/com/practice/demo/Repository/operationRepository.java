package com.practice.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.demo.Table.operation;

public interface operationRepository extends JpaRepository<operation, Long>{
    operation findById(long id);
}
