package org.usfirst.frc3467.other.ultrasonics;

import org.usfirst.frc3467.commands.CommandBase;

public class UltrasonicDoNothing extends CommandBase {
	boolean bool = false;
	
	public UltrasonicDoNothing(boolean bool) {
		requires(ultrasonics);
		this.bool = bool;
	}
	
	protected void initialize() {
		/*
		 * if (!bool) ultrasonics.flop2 = !ultrasonics.flop2; else ultrasonics.flop = !ultrasonics.flop;
		 */
	}
	
	protected void execute() {
		// SmartDashboard.putNumber("Ultrasonic Distance", ultrasonics.getDistance());
		
	}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	}
	
}