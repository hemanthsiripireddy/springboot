package com.hemanth.crudedemo.doa;

import com.hemanth.crudedemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    // all the methods are added by data jpa
}
