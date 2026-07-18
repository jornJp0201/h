package com.crm.admin_app;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;//バリデーション
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name="customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //これを使用することでcustomerIdが自動で生成され、採番の衝突を防ぐことができる
    private Long customerId;

    @Column(name="customer_name",nullable=false)
    @NotBlank(message="顧客名は必須です")
    private String customerName;

    @Email(message = "有効なメールアドレスの形式で入力してください")
    private String customerEmail;

    @DateTimeFormat(pattern="yyyy-MM-dd")//日付のフォーマットを指定することで整合性を保っています。
    @PastOrPresent(message="日付は過去現在にする必要があります")
    @NotNull(message="日付は必須です")
    private LocalDate date;

    @Column(name="text",nullable=true)
    private String text;

    @Column(name="active")//非表示表示用
    private Boolean active = true;


    //コンストラクタ
    public CustomerEntity(){
    }

    public CustomerEntity(Long customerId,String customerName,String customerEmail,LocalDate date,String text,Boolean active){
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.date = date;
        this.text = text;
        this.active = active;
    }

    //ゲッターとセッター

    public void setCustomerId(Long customerId){
        this.customerId=customerId;
    }

    public Long getCustomerId(){
        return customerId;
    }

    public void setCustomerName(String customerName){
        this.customerName=customerName;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void setCustomerEmail(String customerEmail){
        this.customerEmail=customerEmail;
    }
     
    public String getCustomerEmail(){
        return customerEmail;
    }

    public void setDate(LocalDate date){
        this.date=date;
    }

    public LocalDate getDate(){
        return date;
    }

    public void setText(String text){
        this.text=text;
    }

    public String getText(){
        return text;
    }

    public void setActive(Boolean active){
        this.active=active;
    }

    public Boolean getActive(){
        return active;
    }
}
