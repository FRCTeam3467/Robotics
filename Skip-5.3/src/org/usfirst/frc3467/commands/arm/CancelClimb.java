package org.usfirst.frc3467.commands.arm;

import org.usfirst.frc3467.commands.CommandBase;

public class CancelClimb extends CommandBase {
	public static boolean cancelClimb = false;
	private boolean state = false;
	
	public CancelClimb(boolean cancelState) {
		state = cancelState;
	}
	
	protected void initialize() {
		cancelClimb = state;
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
