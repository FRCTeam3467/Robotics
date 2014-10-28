package org.usfirst.frc3467.subsystems.shooter.commands.winch;

import org.usfirst.frc3467.commands.CommandBase;

public class EngageMotor extends CommandBase {
	public EngageMotor() {
		requires(winch);
	}
	
	protected void initialize() {
		
		winch.engageMotor();
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
