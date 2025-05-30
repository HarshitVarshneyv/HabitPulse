package com.HabitPulse.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HabitPulse.model.Habit;
import com.HabitPulse.model.User;
import com.HabitPulse.service.HabitService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainController {

	private final HabitService habitService;
	
	@PostMapping("/users")
	public ResponseEntity<String> registerUser(@RequestBody User user){
		habitService.registerUser(user);
		return ResponseEntity.ok("User registered SuccessFully");
	}
	
	@PostMapping("/habits")
	public ResponseEntity<?> createHabit(@RequestParam Long id , @RequestBody Habit habit){
		habitService.createHabit(id , habit);
		return ResponseEntity.status(HttpStatus.CREATED).body("Habit created SuccessFully");
	}
	
	@PostMapping("/habits/{id}/log")
	public ResponseEntity<String> logHabit(@PathVariable Long id){
		habitService.logHabit(id);
		return ResponseEntity.ok("Habit Created SuccessFully");
	}
	
	@GetMapping("/users/{id}/habits")
	public List<Habit> getAllHabit(@PathVariable Long id){
		return habitService.getAllHabit(id);
	}
	
	@GetMapping("/users/{id}/habits")
	public List<Habit> getAllHabitByTrue(@PathVariable Long id){
		return habitService.getAllHabitByTrue(id);
	}
}




