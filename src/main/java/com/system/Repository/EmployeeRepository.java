package com.system.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	Optional<Employee> deleteById(long id);
	Employee save(Optional<Employee> updateEmp);

}
