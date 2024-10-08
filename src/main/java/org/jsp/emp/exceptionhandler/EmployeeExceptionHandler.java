package org.jsp.emp.exceptionhandler;

import java.sql.SQLIntegrityConstraintViolationException;

import org.jsp.emp.exceptionclasses.NoEmployeeFoundException;
import org.jsp.emp.responsestructure.ResponseStructure;
import org.jsp.emp.service.InvalideEmployeeCredentialException;
import org.jsp.emp.service.NoActiveEmployeeFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeExceptionHandler {
	
	@ExceptionHandler(NoActiveEmployeeFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noActiveEmployeeFoundExceptionHandler(NoActiveEmployeeFoundException e) {
		
		ResponseStructure<String >structure=new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("No Active Employee Found");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure,HttpStatus.NOT_FOUND);;
	}
	@ExceptionHandler(InvalidEmpoleeIdException.class)
	public ResponseEntity<ResponseStructure<String>> invalidEmpoleeIdException(InvalidEmpoleeIdException e){
		

		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Invalid Id.... Employee Not Found..");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure,HttpStatus.NOT_FOUND);;
		
	}
	
	@ExceptionHandler(InvalideEmployeeCredentialException.class)
	public ResponseEntity<ResponseStructure<String>> invalideEmployeeCredentialException( InvalideEmployeeCredentialException e){
		
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Invalid Credential.... Employee Not Found...");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure,HttpStatus.NOT_FOUND); 
		
	}
	@ExceptionHandler(NoEmployeeFoundException.class)
	public ResponseEntity <ResponseStructure<String>>noEmployeeFoundExceptionHandler(NoEmployeeFoundException e){
	ResponseStructure<String>structure=new ResponseStructure<>();
	structure.setStatus(HttpStatus.NOT_FOUND.value());
	structure.setMessage("No Employees Found");
	structure.setBody(e.getMessage());
	return new ResponseEntity(structure,HttpStatus.NOT_FOUND);
}
@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
public ResponseEntity<?>sQLIntegrityConstraintviolationException (SQLIntegrityConstraintViolationException e){
ResponseStructure<String>structure=new ResponseStructure<>();
structure.setStatus(HttpStatus.BAD_REQUEST.value());
structure.setMessage("Invalid Email or phone number");
structure.setBody(e.getMessage());
return new ResponseEntity(structure,HttpStatus.BAD_REQUEST);
}

}
