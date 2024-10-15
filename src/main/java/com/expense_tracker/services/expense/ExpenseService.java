package com.expense_tracker.services.expense;

import java.util.List;

import com.expense_tracker.dto.ExpenseDto;
import com.expense_tracker.entity.Expense;

public interface ExpenseService {
	
	Expense postExpense(ExpenseDto expenseDto);
	
	List<Expense> getAllExpenses();
	
	Expense getExpenseById(Long id);
	Expense updateExpense(Long id,ExpenseDto expenseDto);
	void deleteExpense(Long id);

}
