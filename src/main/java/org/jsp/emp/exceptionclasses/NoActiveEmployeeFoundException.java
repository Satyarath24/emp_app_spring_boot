package org.jsp.emp.exceptionclasses;

import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
public class NoActiveEmployeeFoundException extends RuntimeException{
	
	
	private String message;
	public NoActiveEmployeeFoundException(String message) {
		this.message=message;
		
	}
	@Override
	public String getMessage() {
		return this.message;
	}

}
