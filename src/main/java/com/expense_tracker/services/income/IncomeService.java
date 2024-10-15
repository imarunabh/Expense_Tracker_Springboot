package com.expense_tracker.services.income;

import java.util.List;

import com.expense_tracker.dto.IncomeDto;
import com.expense_tracker.entity.Income;

public interface IncomeService {
	
	Income postIncome(IncomeDto incomeDto);
	List<IncomeDto> getAllIncomes();
	Income updateIncome(Long id, IncomeDto incomeDTO);
	IncomeDto getIncomeById(Long id);
	void deleteIncome(Long id);
}
