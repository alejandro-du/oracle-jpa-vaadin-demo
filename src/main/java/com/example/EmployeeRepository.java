package com.example;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import java.util.List;

@Repository(forEntity = Employee.class)
public interface EmployeeRepository extends EntityRepository<Employee, Long> {

    List<Employee> findByNameLikeIgnoreCase(String name);

}
