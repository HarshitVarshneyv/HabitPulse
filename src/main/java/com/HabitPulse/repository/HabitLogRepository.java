package com.HabitPulse.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HabitPulse.model.HabitLog;

public interface HabitLogRepository extends JpaRepository<HabitLog , Long> {

	HabitLog findByHabitIdIdAndDate(Long habitId, LocalDate today);

}
