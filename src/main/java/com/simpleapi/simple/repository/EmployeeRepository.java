package com.simpleapi.simple.repository;

import com.simpleapi.simple.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    @Query("{ $and : [ {'age': { $gte: ?0 } }, {'age': {$lte: ?1 } } ] }")
    public List<Employee> getEmployeesByAgeRange(Integer begin, Integer end);

    @Query("{'name': ?0}")
    public Employee getEmployeeByName(String name);

}
