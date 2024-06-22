package com.practice.demo.Table;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "customer", schema ="public")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class customer {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long iduser;

		@Column(name="surname")
		private String surname;

		@Column(name="name")
		private String name;

		@Column(name="date_of_birth")
		private Date date_of_birth;

		@Column(name="address")
		private String address;

		@Column(name="phone_number")
		private String phone_number;
	
		
		public customer(String surname, String name, Date date_of_birth, String address, String phone_number) {
			this.surname = surname;
			this.name = name;
			this.date_of_birth = date_of_birth;
			this.address = address;
			this.phone_number = phone_number;
		}
		protected customer(){
			
		}
		public String getCustomerName(){
			return this.surname + " " + this.name + " " + this.iduser;
		}
		@Override
		public String toString() {
			return "Customer info: \n id: " + iduser + "\n Surname: " + surname + "\n Name: " + name + "\n Date of birth: " + date_of_birth + "\n Address: " + address + "\n Phone nunber: " + phone_number;
		}
	}