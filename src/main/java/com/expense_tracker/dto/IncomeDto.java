package com.expense_tracker.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class IncomeDto {
	
    private Long Id;
	
	private String title;
	
	private Integer amount;
	
	private LocalDate date;
	
	private String category;
	
	private String description;

}
