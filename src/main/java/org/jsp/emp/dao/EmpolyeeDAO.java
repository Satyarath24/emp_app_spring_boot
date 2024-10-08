package org.jsp.emp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.entity.Employee;
import org.jsp.emp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpolyeeDAO {
	@Autowired
	private EmployeeRepository repo;
	
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}
	public Employee updatedEmployee1(Employee employee) {
		return repo.save(employee);
	}
	
	public Optional<Employee> findEmployeeById(int id){
		return repo.findById(id);
	}
	
	public List<Employee>findAllEmployee(){
		return repo.findAll();
	}
	public List<Employee>findAllActiveEmployees(){
		return repo.findAllActiveEmployees();
	}
	public void deleteEmployeeById(int id) {
		 repo.deleteById(id);
	}
	public Optional<Employee>findEmployeeByEmailAndPassword(String email,String password){
		return repo.findByEmailAndPassword( email,password);
	}
	
	public List<Employee> findEmployeeByName(String name){
		return repo.findByName(name);
	}
	public Employee updatedEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return repo.save(employee);
	}

}
