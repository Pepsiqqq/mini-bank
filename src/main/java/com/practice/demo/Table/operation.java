package com.practice.demo.Table;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class operation {
        @Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id_operation;

		@Column(name="operation_type")
		private String operation_type;

		@Column(name="date")
		private Date date;

		@Column(name="value")
		private String value;

		@Column(name="operation_subtype")
		private String operation_subtype;

		@Column(name="id_worker")
        private int id_worker;

		@Column(name="id_customer")
		private int id_customer;
		
		public operation(String operation_type, Date date, String value, String operation_subtype, int id_worker, int id_customer) {
			this.operation_type = operation_type;
			this.date = date;
			this.value = value;
			this.operation_subtype = operation_subtype;
            this.id_worker = id_worker;
			this.id_customer = id_customer;
		}
		protected operation(){
			
		}
		public String getOperationtype(){
			return operation_type;
		}
		public Date getDate(){
			return date;
		}
		public String getValue(){
			return value;
		}
		public String getOperationSubtype(){
			return operation_subtype;
		}
		public int getId_Worker(){
			return id_worker;
		}
		public int getId_Customer(){
			return id_customer;
		}
		public Long getId(){
			return id_operation;
		}
}
