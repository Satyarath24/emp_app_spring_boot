package org.jsp.emp.exceptionclasses;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalideEmployeeCredentialException  extends RuntimeException{
	
    private String message;
	
	public InvalideEmployeeCredentialException( String message) {
		
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		
		
	return this.message;
	}
	

}
