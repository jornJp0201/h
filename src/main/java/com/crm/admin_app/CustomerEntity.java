package com.crm.admin_app;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="customers")
public class CustomerEntity {

    @Id
    @Column(name="customer_id", nullable=false,unique=true,length=10)
    private int customerId;

    @Column(name="customer_name",nullable=false)
    private String customerName;

    @Column(name="date",nullable=false,updatable=false)
    private LocalDate date;

    @Column(name="active")
    private String active;

    public CustomerEntity(){
    }

    public CustomerEntity(int customerId,String customerName,LocalDate date,String active){
        this.customerId = customerId;
        this.customerName = customerName;
        this.date = date;
        this.active = active;
    }

    public void setCustomerId(int customerId){
        this.customerId=customerId;
    }

    public int getCustomerId(){
        return customerId;
    }

    public void setCustomerName(String customerName){
        this.customerName=customerName;
    }
}
