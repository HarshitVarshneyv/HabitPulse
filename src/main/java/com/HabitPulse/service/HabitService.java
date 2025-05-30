package com.HabitPulse.service;

import java.util.List;

import com.HabitPulse.model.Habit;
import com.HabitPulse.model.HabitLog;
import com.HabitPulse.model.User;

public interface HabitService {

	User registerUser(User user);
	Habit createHabit(Long id, Habit habit);
	HabitLog logHabit(Long id);
	List<Habit> getAllHabit(Long id);
	List<Habit> getAllHabitByTrue(Long id);
	
}
