package az.ruslan.springjpa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import az.ruslan.springjpa.model.Employee;
import az.ruslan.springjpa.repository.EmployeeRepository;

@RestController
@RequestMapping(path = "/demo")
public class MyController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@PostMapping(path="/save")
	public Iterable<Employee> saveEmployee(@RequestBody Employee emp) {
		employeeRepository.save(emp);
		return employeeRepository.findAll();
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Employee> getAllUsers() {

		return employeeRepository.findAll();
	}
	
	@DeleteMapping(path="/delete/{id}")
	public Iterable<Employee> deleteEmployee(@PathVariable("id") Integer id){
		
		employeeRepository.deleteById(id);
		return employeeRepository.findAll();
	}
	
	@PutMapping(path="/update")
	public Iterable<Employee> updateEmployee(@RequestBody Employee emp ){
		
		employeeRepository.save(emp);
		
		return employeeRepository.findAll();
	}
	

}
