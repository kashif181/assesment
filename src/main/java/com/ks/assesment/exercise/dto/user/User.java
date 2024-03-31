package com.ks.assesment.exercise.dto.user;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class User {
	private String userId;
	private UserType userType;
	private LocalDate registrationDate;
}
