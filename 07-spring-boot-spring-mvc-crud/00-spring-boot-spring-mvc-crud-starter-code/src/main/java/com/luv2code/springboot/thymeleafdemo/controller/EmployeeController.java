package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String getEmployees(Model model){

        model.addAttribute("employees",employeeService.findAll());

        return "employees/list-employees";


    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        model.addAttribute("employee", new Employee());
        return "employees/employee-form";

    }
    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/employees/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id,Model model){
        Employee employee=employeeService.findById(id);
        model.addAttribute("employee",employee);

        return "employees/employee-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id,Model model){
        employeeService.deleteById(id);
        //model.addAttribute("employee",employee);

        return "redirect:/employees/list";
    }

}
