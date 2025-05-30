package com.HabitPulse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HabitPulse.model.Habit;

public interface HabitRepository extends JpaRepository<Habit , Long>{

	List<Habit> findByUserId(Long userid);

}
