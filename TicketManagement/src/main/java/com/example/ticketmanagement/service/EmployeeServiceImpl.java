package com.example.ticketmanagement.service;

import com.example.ticketmanagement.dao.EmployeeRepository;
import com.example.ticketmanagement.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByDetailsAsc();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Did not find employee id -" + theId);
        }
        return theEmployee;
    }

    @Override
    public List<Employee> searchBy(String theName) {
        List<Employee> results = null;
        if (theName != null && (theName.trim().length() > 0)) {
            results = employeeRepository.findByTypeContainsOrDetailsContainsAllIgnoreCase(theName, theName);

        } else {
            results = findAll();
        }
        return results;
    }

    @Override
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }

}