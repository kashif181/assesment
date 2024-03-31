package com.ks.assesment.exercise.dto.user;

import java.util.Objects;

import lombok.Data;

@Data
public class Employee extends User {
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    
	    Employee other = (Employee) obj;
	    
	    return Objects.equals(this.getUserId(), other.getUserId()); // Assuming userId is a unique identifier
	}
	
}
