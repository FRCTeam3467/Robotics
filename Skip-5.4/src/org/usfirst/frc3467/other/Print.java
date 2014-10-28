package org.usfirst.frc3467.other;

import org.usfirst.frc3467.commands.CommandBase;

public class Print extends CommandBase {
	
	private String message;
	
	public Print(String message) {
		this.message = message;
	}
	
	protected void initialize() {
		System.out.println(message);
	}
	
	protected void execute() {
		
	}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	}
	
}
