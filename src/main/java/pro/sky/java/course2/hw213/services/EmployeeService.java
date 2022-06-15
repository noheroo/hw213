package pro.sky.java.course2.hw213.services;

import pro.sky.java.course2.hw213.data.Employee;

import java.util.Collection;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String lastName, String firstName, int salary, int department);

    Employee removeEmployee(String lastName, String firstName);

    Employee findEmployee(String lastName, String firstName);

    Map<String, Employee> printEmployees();

    Collection<Employee> findAll();


}
