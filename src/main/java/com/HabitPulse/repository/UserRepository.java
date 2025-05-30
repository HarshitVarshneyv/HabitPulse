package com.HabitPulse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HabitPulse.model.User;

public interface UserRepository extends JpaRepository<User , Long>{

}
