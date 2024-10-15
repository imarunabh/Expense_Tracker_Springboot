package com.expense_tracker.entity;

import java.time.LocalDate;

import com.expense_tracker.dto.IncomeDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import jakarta.persistence.Id;
@Entity
@Data
public class Income {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long Id;
	
	private String title;
	
	private Integer amount;
	
	private LocalDate date;
	
	private String category;
	
	private String description;
	
	public IncomeDto getIncomeDto() {
		IncomeDto incomeDto = new IncomeDto();
		incomeDto.setId(Id);
		incomeDto.setAmount(amount);
		incomeDto.setCategory(category);
		incomeDto.setDate(date);
		incomeDto.setDescription(description);
		incomeDto.setTitle(title);
		return incomeDto;
	}

}
