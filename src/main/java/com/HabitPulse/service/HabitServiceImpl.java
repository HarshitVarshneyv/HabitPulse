package com.HabitPulse.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.HabitPulse.exception.HabitNotFoundException;
import com.HabitPulse.exception.UserNotFoundException;
import com.HabitPulse.model.Habit;
import com.HabitPulse.model.HabitLog;
import com.HabitPulse.model.User;
import com.HabitPulse.repository.HabitLogRepository;
import com.HabitPulse.repository.HabitRepository;
import com.HabitPulse.repository.UserRepository;

public class HabitServiceImpl implements HabitService{

	private final UserRepository userRepository;
	private final HabitLogRepository habitLogRepository;
	private final HabitRepository habitRepository;
	
	public HabitServiceImpl(UserRepository userRepository,HabitLogRepository habitLogRepository ,HabitRepository habitRepository) {
		this.userRepository = userRepository;
		this.habitLogRepository = habitLogRepository;
		this.habitRepository = habitRepository;
	}
	
	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public Habit createHabit(Long id, Habit habit) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not Exists"));
		
		habit.setUser(user);
		habit.setStartDate(LocalDate.now());
		return habitRepository.save(habit);
	}

	@Override
	public HabitLog logHabit(Long habitId) {
		// TODO Auto-generated method stub
		Habit habit  = habitRepository.findById(habitId)
				.orElseThrow(() -> new HabitNotFoundException("User not Exists"));
		
	    LocalDate today = LocalDate.now();
	    HabitLog existing  = habitLogRepository.findByHabitIdIdAndDate(habitId,today);
	    
	    if(existing != null) return existing;
	    
	    HabitLog log = new HabitLog();
	    log.setHabit(habit);
	    log.setDate(today);
	    log.setCompleted(true);
		return habitLogRepository.save(log);
	}

	@Override
	public List<Habit> getAllHabit(Long userid) {
		// TODO Auto-generated method stub
		return habitRepository.findByUserId(userid);
	}

	@Override
	public List<Habit> getAllHabitByTrue(Long id) {
		// TODO Auto-generated method stub
		return habitRepository.findByUserId(id).stream()
				.filter(habit -> habit.getLogs().stream()
	                    .anyMatch(HabitLog::isCompleted))
//				.filter(h -> h.getLogs().stream()
//						.anyMatch(l -> l.isCompleted()))
				 .collect(Collectors.toList());
	}

}
