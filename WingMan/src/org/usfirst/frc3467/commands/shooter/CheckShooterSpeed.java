package org.usfirst.frc3467.commands.shooter;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.commands.shooter.loader.LoaderPop;
import org.usfirst.frc3467.subsystems.shooter.Shooter;

public class CheckShooterSpeed extends CommandBase {
	
	public static boolean ready = false;
	
	public CheckShooterSpeed() {
		setTimeout(3);
	}
	
	protected void initialize() {
		LoaderPop.cancel = false; // Reset variables
		ready = false;
	}
	
	protected void execute() {
		// If the shooter has been running longer than 1.5 seconds
		// then set its state to ready
		if (System.currentTimeMillis() - Shooter.time > 1500)
			ready = true;
	}
	
	protected boolean isFinished() {
		if (ready) {
			return true;
		} else if (isTimedOut()) {
			LoaderPop.cancel = true;
			return true;
		} else {
			return false;
		}
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	}
}
