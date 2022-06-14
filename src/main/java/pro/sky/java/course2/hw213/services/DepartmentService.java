package pro.sky.java.course2.hw213.services;

import pro.sky.java.course2.hw213.data.Employee;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    Optional<Employee> getEmployeeInDepartmentMinSalary(int department);

    Optional<Employee> getEmployeeInDepartmentMaxSalary(int department);

    List<Employee> printEmployeesInDepartment(int department);

    List<Employee> printEmployeesDepartment();


}
