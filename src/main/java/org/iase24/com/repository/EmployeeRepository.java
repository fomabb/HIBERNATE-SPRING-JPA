package org.iase24.com.repository;

import org.iase24.com.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.firstName=:firsName and e.lastName=:lastName")
    Employee findByFirstNameAndLastName(@Param("firsName") String firsName, @Param("lastName") String lastName);

    Employee findByLastName(String lastName);
}
