package com.springprojects.employeesCRUD.controller;

import com.springprojects.employeesCRUD.entities.Employee;
import com.springprojects.employeesCRUD.repository.EmployeeRepository;
import com.springprojects.employeesCRUD.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/employees")
public class EmployeeController {


    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employee-list";
    }

    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable Long id, Model model) {
        try {

            model.addAttribute("employee", employeeService.getEmployeeById(id));
            return "employee-form";
        } catch (Exception e) {
            return "redirect:/employees";
        }
    }

    @GetMapping("/new")
    public String showEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("action", "/employees/new");
        return "employee-form";
    }

    @PostMapping("/new")
    public String createEmployee(@ModelAttribute @Valid  Employee employee, BindingResult result) {
        if(result.hasErrors()) {
            return "employee-form";
        }
        employeeRepository.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        model.addAttribute("employee", employee);
        model.addAttribute("action", "/employees/edit/" + id);
        model.addAttribute("cancel", "/employees/");
        //System.out.println(model.getAttribute("action"));
        return "employee-form";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute @Valid Employee employee, BindingResult result) {
        if(result.hasErrors()) {
            return "employee-form";
        }
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            employeeRepository.save(employee);
        }
        return "redirect:/employees";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return "redirect:/employees";
    }
}

