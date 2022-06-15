package pro.sky.java.course2.hw213.services;

import pro.sky.java.course2.hw213.data.Employee;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    Employee getEmployeeInDepartmentMinSalary(int department);

    Employee getEmployeeInDepartmentMaxSalary(int department);

    List<Employee> printEmployeesInDepartment(int department);

    List<Employee> printEmployeesDepartment();


}
