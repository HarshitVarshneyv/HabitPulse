package com.HabitPulse.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Habit {

	private Long id;
	private String title;
	private String description;
	private LocalDate startDate;
	private boolean isActive;
	
	@ManyToOne
	@JoinColumn(name = "user_id" , nullable = false)
	private User user;
	
	@OneToMany(mappedBy = "habit" , cascade = CascadeType.ALL , orphanRemoval = false)
	private List<HabitLog> logs = new ArrayList<>();
}
