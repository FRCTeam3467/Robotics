package org.usfirst.frc3467.subsystems.shooter.commands;

import org.usfirst.frc3467.commands.CommandBase;

public class WaitForError extends CommandBase {
	double accuracy;
	
	public WaitForError(double accuracy) {
		this.accuracy = accuracy;
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		
	}
	
	protected boolean isFinished() {
		return Math.abs(mast.getError()) < accuracy;
	}
	
	protected void end() {
		System.out.println("Within range: " + mast.getError());
	}
	
	protected void interrupted() {
		
	}
	
}
