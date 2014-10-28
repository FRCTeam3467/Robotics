package org.usfirst.frc3467.commands.shooter;

import org.usfirst.frc3467.commands.CommandBase;

public class SetShooterSpeed extends CommandBase {
	double speed = 0.0;
	
	public SetShooterSpeed(double shooterSpeed) {
		requires(shooter);		// Requires the shooter subsystem
		speed = shooterSpeed;
	}
	
	protected void execute() {
		shooter.setSpeed(speed); // Set the shooter speed
	}
	
	protected void initialize() {
		
	}
	
	protected void interrupted() {
		
	}
	
	protected boolean isFinished() {
		return true; 			// Will only end if it is interrupted
	}
	
	protected void end() {
		
	}
	
}
