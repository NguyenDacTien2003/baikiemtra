package com.example.ticketmanagement.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "time")
    public Date time;

    @Column(name = "price")
    private double price;

    @Column(name = "type")
    private String type;
    @Column(name = "details")
    private String details;

    public Employee(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }
    public String getDetails() {
        return details;
    }

    public void setDetails (String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", price='" + price + '\'' +
                ", type='" + type + '\'' +
                ", details='" + details + '\'' +
                '}';
    }

    public Employee(int id, Date time, Double price, String type, String details) {
        this.id = id;
        this.time = time;
        this.price = price;
        this.type = type;
        this.details=details;
    }


}