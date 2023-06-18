package com.simpleapi.simple.service.impl;

import com.simpleapi.simple.model.Employee;
import com.simpleapi.simple.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements com.simpleapi.simple.service.EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getByID(String ID) {
        return this.employeeRepository
                .findById(ID)
                .orElseThrow(() -> new IllegalArgumentException("Employee Not Found!"));
    }

    @Override
    public Employee create(Employee employee) {

        Employee boss = this.employeeRepository
                .findById(employee.getBoss().getId())
                .orElseThrow(()-> new IllegalArgumentException("Boss not found."));

        employee.setBoss(boss);

        return this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeesByAgeRange(Integer begin, Integer end) {
        return this.employeeRepository.getEmployeesByAgeRange(begin, end);
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return this.employeeRepository.getEmployeeByName(name);
    }
}
