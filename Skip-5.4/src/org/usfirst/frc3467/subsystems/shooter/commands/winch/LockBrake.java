package org.usfirst.frc3467.subsystems.shooter.commands.winch;

import org.usfirst.frc3467.commands.CommandBase;

public class LockBrake extends CommandBase {
	public LockBrake() {
		requires(winch);
	}
	
	protected void initialize() {
		// System.out.println("Locking Break");
		winch.lockBrake();
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
