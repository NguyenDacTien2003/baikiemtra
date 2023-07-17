package com.example.ticketmanagement.dao;
import com.example.ticketmanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface  EmployeeRepository extends JpaRepository<Employee,Integer> {


    public List<Employee> findAllByOrderByDetailsAsc();


    public List<Employee> findByTypeContainsOrDetailsContainsAllIgnoreCase(String Name, String lName);
}