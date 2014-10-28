package org.usfirst.frc3467.subsystems.shooter.commands;

import org.usfirst.frc3467.subsystems.shooter.Winch;

import edu.wpi.first.wpilibj.command.Command;

public class WaitForWinch extends Command {
	double percentage;
	
	public WaitForWinch(double percentage) {
		this.percentage = percentage;
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		
	}
	
	protected boolean isFinished() {
		return Winch.getInstance().pot.get() <= Winch.difference * percentage;
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	}
	
}
