package org.usfirst.frc3467.other;

import org.usfirst.frc3467.commands.CommandBase;

public class Reverse extends CommandBase {
	public static boolean reverse = false;
	
	protected void initialize() {
		reverse = !reverse;
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
