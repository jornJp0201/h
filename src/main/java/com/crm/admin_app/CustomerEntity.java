package com.crm.admin_app;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class CustomerEntity {

    @Id
    @Column(name="customer_id")
    private int customerId;
    
}
