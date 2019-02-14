package az.ruslan.springjpa.repository;


import org.springframework.data.repository.CrudRepository;

import az.ruslan.springjpa.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	

}
