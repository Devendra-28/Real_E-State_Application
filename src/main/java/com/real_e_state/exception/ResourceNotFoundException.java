package com.real_e_state.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
	String resourceName;
	String feildName;
	long feildvalue;
	public ResourceNotFoundException(String resourceName, String feildName, long feildvalue) {
		super(String.format("%s not found with %s :%s", resourceName,feildName,feildvalue));
		this.resourceName = resourceName;
		this.feildName = feildName;
		this.feildvalue = feildvalue;
	}

}
