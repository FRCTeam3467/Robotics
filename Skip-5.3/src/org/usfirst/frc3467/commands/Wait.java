package org.usfirst.frc3467.commands;

import org.usfirst.frc3467.commands.arm.CancelClimb;

public class Wait extends CommandBase {
	public Wait(double seconds) {
		this.setTimeout(seconds);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		
	}
	
	protected boolean isFinished() {
		if (isTimedOut() || CancelClimb.cancelClimb)
			return true;
		else
			return false;
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	}
	
}
