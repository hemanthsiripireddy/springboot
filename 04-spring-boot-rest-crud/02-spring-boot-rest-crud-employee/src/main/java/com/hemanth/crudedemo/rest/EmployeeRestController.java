package com.hemanth.crudedemo.rest;

import com.hemanth.crudedemo.doa.EmployeeDao;
import com.hemanth.crudedemo.entity.Employee;
import com.hemanth.crudedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();

    }

    @GetMapping("/employees/{studentId}")
    public Employee getById(@PathVariable int studentId) {
        Employee employee = employeeService.findById(studentId);

        if (employee == null)
            throw new RuntimeException("Employee not found with id: " + studentId);
        return employee;

    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        Employee dbEmployee = employeeService.findById(employee.getId());
        if (dbEmployee == null)
            throw new RuntimeException("Employee not found with id: " + employee.getEmail() + " to update");
        dbEmployee = employeeService.save(employee);
        return dbEmployee;

    }
    @DeleteMapping("/employees/{employeeId}")
    public String updateEmployee(@PathVariable int employeeId) {

        Employee dbEmployee = employeeService.findById(employeeId);
        if (dbEmployee == null)
            throw new RuntimeException("Employee not found with id: " + employeeId + " to delete");
        employeeService.deleteById(employeeId);

        return "Employee Deleted with id: "+employeeId;

    }
}
