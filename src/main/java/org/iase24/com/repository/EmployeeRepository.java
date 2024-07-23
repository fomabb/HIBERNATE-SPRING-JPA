package org.iase24.com.repository;

import org.iase24.com.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    void add(Employee employee);

    List<Employee> getAll();

    Employee getById(Long id);

    void update(Employee employee);

    void remove(Employee employee);
}
