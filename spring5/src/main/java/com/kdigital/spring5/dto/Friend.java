package com.kdigital.spring5.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Friend {
	private String username;
	private Integer age;
	private String phone;
	private LocalDate birthday;	
	private boolean active;
}
