package pro.sky.java.course2.hw213.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.hw213.services.EmployeeService;
import pro.sky.java.course2.hw213.services.EmployeeServiceImpl;
import pro.sky.java.course2.hw213.data.Employee;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String lastname,
                              @RequestParam String firstname,
                              @RequestParam int salary,
                              @RequestParam int department) {
        return employeeService.addEmployee(lastname, firstname, salary, department);

    }

    @GetMapping("/remove")
    public Employee deleteEmployee(@RequestParam String lastname, @RequestParam String firstname) {
        return employeeService.removeEmployee(lastname, firstname);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String lastname, @RequestParam String firstname) {
        return employeeService.findEmployee(lastname, firstname);
    }

    @GetMapping("/print")
    public Map<String, Employee> printEmployees() {
        return employeeService.printEmployees();
    }
}
