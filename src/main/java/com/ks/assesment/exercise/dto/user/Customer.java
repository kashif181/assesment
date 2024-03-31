package com.ks.assesment.exercise.dto.user;

import java.time.LocalDate;
import java.util.Objects;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Customer extends User {
	private LocalDate registrationDate;
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    
	    Customer other = (Customer) obj;
	    
	    return Objects.equals(this.getUserId(), other.getUserId()); // Assuming userId is a unique identifier
	}
}
