package com.expense_tracker.dto;

import java.util.List;

import com.expense_tracker.entity.Expense;
import com.expense_tracker.entity.Income;

import lombok.Data;

@Data
public class GraphDto {
	
	private List<Expense> expenseList;
	private List<Income> incomeList;

}
