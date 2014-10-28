package org.usfirst.frc3467.subsystems.shooter.commands.auto;

import org.usfirst.frc3467.CommandBasedRobot;
import org.usfirst.frc3467.commands.CommandBase;

public class WaitForSignal extends CommandBase {
	
	public WaitForSignal() {
		
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		
	}
	
	protected boolean isFinished() {
		return CommandBasedRobot.server.getRightStatus();
	}
	
	protected void end() {
		System.out.println("Signal givin");
	}
	
	protected void interrupted() {
		
	}
	
}
