package com.hemanth.crudedemo.service;

import com.hemanth.crudedemo.doa.EmployeeRepository;
import com.hemanth.crudedemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        this.employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result=employeeRepository.findById(id);
        Employee tEmployee=null;
        if(!result.isPresent())
            throw  new RuntimeException("Employee not found with id: "+id);
        tEmployee=result.get();
        return tEmployee;


    }

    @Override

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override

    public void deleteById(int id) {

        employeeRepository.deleteById(id);

    }
}
