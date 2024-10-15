package com.expense_tracker.services.stats;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import org.springframework.stereotype.Service;

import com.expense_tracker.dto.GraphDto;
import com.expense_tracker.dto.StatsDto;
import com.expense_tracker.entity.Expense;
import com.expense_tracker.entity.Income;
import com.expense_tracker.repository.ExpenseRepository;
import com.expense_tracker.repository.IncomeRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService{
	
	private final IncomeRepository incomeRepository;
	private final ExpenseRepository expenseRepository;
	
	public GraphDto getChartDate() {
		LocalDate endDate = LocalDate.now();
		LocalDate startDate = endDate.minusDays(27);
		GraphDto graphDto = new GraphDto();
		graphDto.setExpenseList(expenseRepository.findByDateBetween(startDate, endDate));
		graphDto.setIncomeList(incomeRepository.findByDateBetween(startDate, endDate));
		return graphDto;
	}
	
	public StatsDto getStats() {
		Double totalIncome = incomeRepository.sumAllAmounts();
		Double totalExpense = incomeRepository.sumAllAmounts();
		
		Optional<Income> optionalIncome = incomeRepository.findFirstByOrderByDateDesc();
		Optional<Expense> optionalExpense = expenseRepository.findFirstByOrderByDateDesc();
		
		
		StatsDto statsDto= new StatsDto();
		statsDto.setExpense(totalExpense);
		statsDto.setIncome(totalIncome);
		if(optionalIncome.isPresent()) {
			statsDto.setLatestIncome(optionalIncome.get());
		}
		
		if(optionalExpense.isPresent()) {
			statsDto.setLatestExpense(optionalExpense.get());
		}
		
		statsDto.setBalance(totalIncome-totalExpense);
		List<Income> incomeList = incomeRepository.findAll();
		List<Expense> expenseList = expenseRepository.findAll();
		OptionalDouble minIncome = incomeList.stream().mapToDouble(Income::getAmount).min();
		OptionalDouble maxIncome = incomeList.stream().mapToDouble(Income::getAmount).max();
		
		OptionalDouble minExpense = expenseList.stream().mapToDouble(Expense::getAmount).min();
		OptionalDouble maxExpense = expenseList.stream().mapToDouble(Expense::getAmount).max();
		
		statsDto.setMinIncome(minIncome.isPresent()?minIncome.getAsDouble():null);
		statsDto.setMaxIncome(maxIncome.isPresent()?maxIncome.getAsDouble():null);
		
		statsDto.setMinExpense(minIncome.isPresent()?minExpense.getAsDouble():null);
		statsDto.setMaxExpense(maxExpense.isPresent()?maxExpense.getAsDouble():null);
		
		
		return statsDto;
	}

}
