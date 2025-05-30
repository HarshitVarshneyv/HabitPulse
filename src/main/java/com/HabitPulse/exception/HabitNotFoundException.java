package com.HabitPulse.exception;

public class HabitNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public HabitNotFoundException(String msg) {
		super(msg);
	}
}
