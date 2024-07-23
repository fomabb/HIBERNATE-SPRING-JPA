package org.iase24.com.service;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.iase24.com.entity.Employee;
import org.iase24.com.repository.EmployeeRepository;
import org.iase24.com.util.SessionUtil;

import java.util.List;

public class EmployeeServiceImpl extends SessionUtil implements EmployeeRepository {

    public void add(Employee employee) {
        openTransactionSession();

        Session session = getSession();
        session.save(employee);
        closeTransactionSession();
    }

    public List<Employee> getAll() {
        openTransactionSession();

        Session session = getSession();
        String sql = "SELECT * FROM address";
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        List<Employee> employees = query.list();
        closeTransactionSession();

        return employees;
    }

    public Employee getById(Long id) {
        openTransactionSession();

        Session session = getSession();
        String sql = "SELECT * FROM employee WHERE id=:id";
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        query.setParameter("id", id);
        Employee employee = (Employee) query.getSingleResult();
        Hibernate.initialize(employee.getAddress());
        closeTransactionSession();

        return employee;
    }

    public void update(Employee employee) {
        openTransactionSession();

        Session session = getSession();
        session.update(employee);
        closeTransactionSession();
    }

    public void remove(Employee employee) {
        openTransactionSession();

        Session session = getSession();
        session.remove(employee);
        closeTransactionSession();
    }
}
