package com.expense_tracker.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense_tracker.dto.GraphDto;
import com.expense_tracker.services.stats.StatsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StatsController {
	
	private final StatsService statsService;
	
	@GetMapping("/chart")
	public ResponseEntity<GraphDto> getChartDetail(){
		return ResponseEntity.ok(statsService.getChartDate());
	}
	
	@GetMapping
	public ResponseEntity<?> getStats(){
		return ResponseEntity.ok(statsService.getStats());
	}
	
	

}
