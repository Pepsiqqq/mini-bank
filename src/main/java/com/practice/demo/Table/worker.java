package com.practice.demo.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class worker {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id_worker;
        private String name;
        private String surname;

    public worker(String name, String surname){
        this.name = name;
        this.surname = surname;

    }
    protected worker(){

    }
    public String getWorkerName(){
        return surname + " " + name + " " + id_worker;
    }
}
