package com.practice.demo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.grammars.hql.HqlParser.SortDirectionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.practice.demo.Repository.customerRepository;
import com.practice.demo.Repository.operationRepository;
import com.practice.demo.Repository.workerRepository;
import com.practice.demo.Table.customer;
import com.practice.demo.Table.operation;
import com.practice.demo.Table.worker;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class operationController {
    @Autowired
    operationRepository operationrepository;

    @Autowired
    workerRepository workerrepository;

    @Autowired
    customerRepository customerrepository;
    
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public class operationmod{
       
        private Long id_operation;
		private String operation_type;
		private Date date;
		private String value;
		private String operation_subtype;
        private String workerName;
        private String customerName;

        public operationmod(Long id_operation,String operation_type , Date date, String value, String operation_subtype, String workerName, String customerName){
            this.id_operation = id_operation;
            this.operation_type = operation_type;
			this.date = date;
			this.value = value;
			this.operation_subtype = operation_subtype;
            this.workerName = workerName;
            this.customerName = customerName;
        }
        private operationmod(){

        }

    }
    @DeleteMapping("/operationRemove/{id}")
    public void removeOperation(@PathVariable Long id){
        operationrepository.deleteById(id);
    }

    @PostMapping("/operationAdd")
    public void newOperation(@RequestBody operation newOperation){
        operationrepository.save(newOperation);
    }
    @GetMapping("/operationdata")
    public List<operationmod> getallOperations(){
        List<operation> operations = operationrepository.findAll(); 
        List<worker> workers = workerrepository.findAll();
        List<customer> customers = customerrepository.findAll(Sort.by(Sort.Direction.ASC, "iduser"));
        List<operationmod> operationsmods = new ArrayList();
        for(int i = 0 ; i < operations.size(); i++ ){
            operationmod temp = new operationmod(operations.get(i).getId(),operations.get(i).getOperationtype(),operations.get(i).getDate(),
            operations.get(i).getValue(),operations.get(i).getOperationSubtype(),
            workers.get(operations.get(i).getId_Worker()-1).getWorkerName(),
            customers.get(operations.get(i).getId_Customer()-1).getCustomerName());
            
            System.out.println(operations.get(i).getId_Customer()-1);
            System.out.println(customers.get(operations.get(i).getId_Customer()-1).getCustomerName());
            
            operationsmods.add(temp);
        }
        return operationsmods;
    }
}
