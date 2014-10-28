package org.usfirst.frc3467.subsystems.shooter.commands.winch;

import org.usfirst.frc3467.commands.CommandBase;

public class DisengageMotor extends CommandBase {
	public DisengageMotor() {
		requires(winch);
	}
	
	protected void initialize() {
		// System.out.println("Disengaging motor");
		winch.disengageMotor();
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
