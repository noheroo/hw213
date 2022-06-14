package pro.sky.java.course2.hw213.services;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.hw213.data.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Optional<Employee>  getEmployeeInDepartmentMinSalary(int department) {
        return Optional.ofNullable(employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparing(e -> e.getSalary()))
                .orElseThrow(() -> new RuntimeException("Employee not found")));
    }

    @Override
    public Optional<Employee> getEmployeeInDepartmentMaxSalary(int department) {
        return Optional.ofNullable(employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparing(e -> e.getSalary()))
                .orElseThrow(() -> new RuntimeException("Employee not found")));

    }

    @Override
    public List<Employee> printEmployeesInDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> printEmployeesDepartment() {
        return employeeService.findAll().stream()
                .sorted(Comparator.comparing(e->e.getDepartment()))
                .collect(Collectors.toList());
    }
}
