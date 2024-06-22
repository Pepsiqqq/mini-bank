package com.practice.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.demo.Table.worker;

public interface workerRepository extends JpaRepository<worker, Long>{
    worker findById(long id);
}
