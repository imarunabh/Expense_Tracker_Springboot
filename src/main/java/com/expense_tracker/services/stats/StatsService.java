package com.expense_tracker.services.stats;

import com.expense_tracker.dto.GraphDto;
import com.expense_tracker.dto.StatsDto;

public interface StatsService {
	GraphDto getChartDate();
	StatsDto getStats();

}
