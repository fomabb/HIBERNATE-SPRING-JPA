package org.iase24.com;

import org.iase24.com.entity.Address;
import org.iase24.com.entity.Employee;
import org.iase24.com.entity.Project;
import org.iase24.com.service.AddressServiceImpl;
import org.iase24.com.service.EmployeeServiceImpl;
import org.iase24.com.service.ProjectServiceImpl;
import org.iase24.com.util.HibernateUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        AddressServiceImpl addressService = new AddressServiceImpl();
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        ProjectServiceImpl projectService = new ProjectServiceImpl();

        Address address = new Address();
        address.setCountry("Belarus");
        address.setCity("Zhabinka");
        address.setPostCode("12345");

        Project project = new Project();
        project.setTitle("Aggregator");

        Employee employee = new Employee();
        employee.setFirstName("Nikolay");
        employee.setLastName("Kirilyuk");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1991, Calendar.FEBRUARY, 21);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Set<Employee> employees = new HashSet<Employee>();
        employees.add(employee);
        project.setEmployees(employees);

        Set<Project> projects = new HashSet<Project>();
        projects.add(project);
        employee.setProjects(projects);

//        addressService.add(address);
//        employeeService.add(employee);
//        projectService.add(project);

        Employee byId = employeeService.getById(1L);
        System.out.println("\n" + byId + "\n");

        HibernateUtil.shutdown();
    }
}
