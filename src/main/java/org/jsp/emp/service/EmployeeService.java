package org.jsp.emp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.dao.EmpolyeeDAO;
import org.jsp.emp.entity.Employee;
import org.jsp.emp.exceptionclasses.NoEmployeeFoundException;
import org.jsp.emp.responsestructure.ResponseStructure;
import org.jsp.emp.util.EmployeeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

	@Autowired
	private EmpolyeeDAO dao;
	
	public ResponseEntity<?> saveEmployee(Employee employee) {
		employee.setStatus(EmployeeStatus.IN_ACTIVE);
		employee = dao.saveEmployee(employee);


		
//		ResponseStructure<Employee> structure = new ResponseStructure<>();
////		structure.setStatus(HttpStatus.CREATED.value());
////		structure.setMessage("Employee Saved Sucessfully");
////		structure.setBody(employee);
		
		//ResponseStructure<Object>st=ResponseStructure.builder().status(HttpStatus.CREATED.value()).message("Employee Saved Sucessfully").Body(employee).build();
		
return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.builder().status(HttpStatus.CREATED.value()).message("Employee saved successfully...").Body(employee).build());
}
	public ResponseEntity<?> updateEmployee(Employee employee) {
		employee = dao.updatedEmployee(employee);

		ResponseEntity<?> structure = new ResponseStructure();
//		structure.setStatus(HttpStatus.OK.value());
//		structure.setMessage("Employee Updated Sucessfully");
//		structure.setBody(employee);
		return ResponseEntity.status(HttpStatus.OK.).body(ResponseStructure.builder().status(HttpStatus.CREATED.value()).message("Employee saved successfully...").Body(employee).build());
	}

	public ResponseStructure<Employee> findEmployeeById(int id) {
		Optional<Employee> optional = dao.findEmployeeById(id);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if (optional.isEmpty()) {
			throw InvalidEmployeeIdException.builder().message("Invalid Employee Id..Unable to find Employee...").build();
		
		}
	//	{
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("Employee Not Found");
//			structure.setBody(null);
//			return structure;
//		}

		Employee emp = optional.get();
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setMessage("Employee Found Sucess");
		structure.setBody(emp);
		return structure;
	}

	public ResponseStructure<List<Employee>> findAllEmployees() {
		List<Employee> el = dao.findAllEmployee();
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if(el.isEmpty()) {
			throw new NoActiveEmployeeFoundException("No Active Employee Present in the Table....");
		}
		
		
//		if (el.isEmpty()) {
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage(" No Employee Found");
//			structure.setBody(el);
//			return structure;
//		}
//		ArrayList<Employee>activeEmployees=new ArrayList();
//		for(Employee e:el) {
//			
//		if(e.getStatus()==EmployeeStatus.ACTIVE)	
//			activeEmployees.add(e);
//			
			
	//	}
		
		
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setMessage("Employee Available");
		structure.setBody(el);
		return structure;
	}

	public ResponseStructure<String> deleteEmployeeById(int id) {
		Optional<Employee> op = dao.findEmployeeById(id);
		ResponseStructure<String> structure = new ResponseStructure<>();
		if (op.isEmpty()) {
			throw new InvalidEmpoleeIdException("Invalide Employee id...unable delete Employee");
		}
//		{
//			structure.setStatus(HttpStatus.BAD_REQUEST.value());
//			structure.setMessage("Invalid id");
//			structure.setBody("Unable To Delete Employee");
//			return structure;
//		}
		dao.deleteEmployeeById(id);
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Employee Deleted");
		structure.setBody(null);
		return structure;
	}

//	public ResponseStructure<Employee> findEmployeeEmailAndPassword(String email, String password) {
//		Optional<Employee> op = dao.findEmployeeByEmailAndPassword(email, password);
//		ResponseStructure<Employee> structure = new ResponseStructure<>();
//		if(op.isEmpty())
//		{
//			throw new InvalideEmployeeCredentialException("Invalide Credential.........");
//		}
//		{
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("Invalid Credential");
//			structure.setBody(null);
//			return structure;
//
//		}
//		Employee emp = op.get();
//		structure.setStatus(HttpStatus.OK.value());
//		structure.setMessage("Employee Found Sucessfully");
//		structure.setBody(emp);
//		return structure;
//	}

	public ResponseStructure<List<Employee>> findEmployeeByName(String name) {
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		List<Employee> el = dao.findEmployeeByName(name);

		if (el.isEmpty()) {
			throw new NoEmployeeFoundException("No MAtching Employeee found ");
		}
//		{
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("No Employee Named " + name);
//			structure.setBody(el);
//			return structure;
//		}
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setMessage("Employee Available With" + name + "is");
		structure.setBody(el);
		return structure;
	}
	public ResponseStructure<Employee> findEmployeeByEmailAndPassword(String email, String password) {

		Optional<Employee> el = dao.findEmployeeByEmailAndPassword(email,password);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if (el.isEmpty()) {
			throw new InvalideEmployeeCredentialException("Invalide Credential.........");
		}
//		{
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("No Employee Named ");
//			structure.setBody(null);
//			return structure;
//		}
	Employee emp = el.get();
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setMessage("Employee Available With");
		structure.setBody(emp);
		return structure;

	}
	public ResponseStructure<Employee>setEmployeeStatusToActive(int id){
		Optional<Employee>optional=dao.findEmployeeById(id);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if(optional.isEmpty()) {
			throw new InvalidEmpoleeIdException("Invalide Employee id...unable to change EmployeeStatus as Active  ");
		}
//		{
//			structure.setStatus(HttpStatus.BAD_REQUEST.value());
//			structure.setMessage("Invalid Employee ID ... Unable to MAke Active ");
//			structure.setBody(null);
//			return structure;	
//			}
		Employee employee = optional.get();
		employee.setStatus(EmployeeStatus.ACTIVE);
		employee=dao.updatedEmployee(employee);
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("employee status updated to active  ");
		structure.setBody(employee);
		
		return structure;
	}
	public ResponseStructure<Employee> setEmployeeStatusToInActive(int id) {
		Optional<Employee>optional=dao.findEmployeeById(id);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if(optional.isEmpty()) {
			throw new InvalidEmpoleeIdException("Invalide Employee id...unable to change EmployeeStatus as IN_Active  ");
		}
//		{
//			structure.setStatus(HttpStatus.BAD_REQUEST.value());
//			structure.setMessage("Invalid Employee ID ... Unable to MAke Active ");
//			structure.setBody(null);
//			return structure;	
//		}
		Employee employee = optional.get();
		employee.setStatus(EmployeeStatus.IN_ACTIVE);
		employee=dao.updatedEmployee(employee);
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage(" employee status updated to  In_Active ");
		structure.setBody(employee);
		
		return structure;
	}

}
