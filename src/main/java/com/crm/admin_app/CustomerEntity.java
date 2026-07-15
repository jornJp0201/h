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
    private String customerId;

    @Column(name="customer_name",nullable=false)
    private String customerName;

    @Column(name="date",nullable=false,updatable=false)
    private LocalDate date;

    @Column(name="active")
    private String active;


    //コンストラクタ
    public CustomerEntity(){
    }

    public CustomerEntity(String customerId,String customerName,LocalDate date,String active){
        this.customerId = customerId;
        this.customerName = customerName;
        this.date = date;
        this.active = active;
    }

    //ゲッターとセッター

    public void setCustomerId(String customerId){
        this.customerId=customerId;
    }

    public String getCustomerId(){
        return customerId;
    }

    public void setCustomerName(String customerName){
        this.customerName=customerName;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void setDate(LocalDate date){
        this.date=date;
    }

    public LocalDate getDate(){
        return date;
    }

    public void setActive(String active){
        this.active=active;
    }

    public String getActive(){
        return active;
    }
}
