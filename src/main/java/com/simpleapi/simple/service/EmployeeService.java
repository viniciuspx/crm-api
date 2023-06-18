package com.simpleapi.simple.service;


import com.simpleapi.simple.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAll();
    public Employee getByID(String ID);
    public Employee create(Employee employee);
    public List<Employee> getEmployeesByAgeRange(Integer begin, Integer end);
    public Employee getEmployeeByName(String name);
}
