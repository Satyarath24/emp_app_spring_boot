package org.jsp.emp.exceptionclasses;

import org.jsp.emp.responsestructure.ResponseStructure.ResponseStructureBuilder;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidEmployeeIdException extends RuntimeException {
	
	private String message;
	
	public InvalidEmployeeIdException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		return this.message;
	}
	
	}


