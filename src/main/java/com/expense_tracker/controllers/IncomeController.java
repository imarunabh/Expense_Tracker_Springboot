package com.expense_tracker.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense_tracker.dto.IncomeDto;
import com.expense_tracker.entity.Income;
import com.expense_tracker.services.income.IncomeService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/income")
@RequiredArgsConstructor
@CrossOrigin("*")
public class IncomeController {
	
	private final IncomeService incomeService;
	
	@PostMapping
	public ResponseEntity<?> postIncome(@RequestBody IncomeDto incomeDto){
		Income createdIncome = incomeService.postIncome(incomeDto);
		if(createdIncome!=null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createdIncome);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllIncome(){
		return ResponseEntity.ok(incomeService.getAllIncomes());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateIncome(@PathVariable("id") Long id,@RequestBody IncomeDto incomeDto){
		try {
		    System.out.println(incomeService.updateIncome(id, incomeDto));
			return ResponseEntity.ok(incomeService.updateIncome(id, incomeDto));
		}
		catch(EntityNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}
		catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
		   
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getIncomeById(@PathVariable("id") Long id){
		try {
			return ResponseEntity.ok(incomeService.getIncomeById(id));
		}
		catch(EntityNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteIncome(@PathVariable("id") Long id){
		try {
			incomeService.deleteIncome(id);
			return ResponseEntity.ok(null);
		}
		catch(EntityNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
		}
		
	}
}
