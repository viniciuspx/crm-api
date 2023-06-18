package com.simpleapi.simple.controller;

import com.simpleapi.simple.model.Employee;
import com.simpleapi.simple.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        return this.employeeService.getAll();
    }

    @GetMapping("/{ID}")
    public Employee getByID(@PathVariable String ID) {
        return this.employeeService.getByID(ID);
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return this.employeeService.create(employee);
    }

    @GetMapping("/range")
    public List<Employee> getEmployeesByAgeRange(@RequestParam("begin") Integer begin, @RequestParam("end") Integer end) {
        return this.employeeService.getEmployeesByAgeRange(begin, end);
    }

    @GetMapping("/name")
    public Employee getEmployeeByName(@RequestParam("name") String name){
        return this.employeeService.getEmployeeByName(name);
    }
}
