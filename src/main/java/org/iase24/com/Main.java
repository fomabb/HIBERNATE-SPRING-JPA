package org.iase24.com;

import lombok.extern.slf4j.Slf4j;
import org.iase24.com.entity.Address;
import org.iase24.com.entity.Employee;
import org.iase24.com.entity.Project;
import org.iase24.com.repository.AddressRepository;
import org.iase24.com.repository.EmployeeRepository;
import org.iase24.com.repository.ProjectRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        AddressRepository addressRepository = context.getBean(AddressRepository.class);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        ProjectRepository projectRepository = context.getBean(ProjectRepository.class);


//        Address address = new Address();
//        address.setCountry("Belarus");
//        address.setCity("Zhabinka");
//        address.setPostCode("12345");
//
//        Project project = new Project();
//        project.setTitle("Aggregator");
//
//        Employee employee = new Employee();
//        employee.setId(1L);
//        employee.setFirstName("Nikolay");
//        employee.setLastName("Kirilyuk");
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(1991, Calendar.FEBRUARY, 21);
//
//        employee.setBirthday(new Date(calendar.getTime().getTime()));
//        employee.setAddress(address);
//
//        Set<Employee> employees = new HashSet<Employee>();
//        employees.add(employee);
//        project.setEmployees(employees);
//
//        Set<Project> projects = new HashSet<Project>();
//        projects.add(project);
//        employee.setProjects(projects);
//
//        addressRepository.save(address);
//        employeeRepository.save(employee);
//        projectRepository.save(project);

        System.out.println();
        System.out.println(employeeRepository.findByFirstNameAndLastName("Nikolay", "Kirilyuk"));
        System.out.println();
    }
}
