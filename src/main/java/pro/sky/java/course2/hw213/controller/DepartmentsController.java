package pro.sky.java.course2.hw213.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.hw213.services.DepartmentService;
import pro.sky.java.course2.hw213.services.DepartmentServiceImpl;
import pro.sky.java.course2.hw213.data.Employee;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {

    private final DepartmentService departmentsService;

    public DepartmentsController(DepartmentServiceImpl departmentsService) {
        this.departmentsService = departmentsService;
    }

    @GetMapping("/min-salary")
    public Employee  getEmployeeInDepartmentMinSalary(@RequestParam int department) {
        return departmentsService.getEmployeeInDepartmentMinSalary(department);
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeInDepartmentMaxSalary(@RequestParam int department) {
        return departmentsService.getEmployeeInDepartmentMaxSalary(department);
    }

    @GetMapping("/print-department")
    public List<Employee> printEmployeesInDepartment(@RequestParam int department) {
        return departmentsService.printEmployeesInDepartment(department);
    }

    @GetMapping("/print-all")
    public List<Employee> printEmployeesInDepartment() {
        return departmentsService.printEmployeesDepartment();
    }
}
