package com.example;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface EmployeeRepository extends EntityRepository<Employee, Long> {

    List<Employee> findByNameLikeIgnoreCase(String name);

}
