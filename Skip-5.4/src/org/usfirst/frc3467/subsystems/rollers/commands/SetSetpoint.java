package org.usfirst.frc3467.subsystems.rollers.commands;

import org.usfirst.frc3467.commands.CommandBase;

public class SetSetpoint extends CommandBase {
	
	private double setpoint;
	private boolean front = false;
	
	public SetSetpoint(double setpoint, boolean front) {
		this.setpoint = setpoint;
		
	}
	
	protected void initialize() {
		System.out.println("Front Wanted Setpoint: " + setpoint);
		if (front)
			roller.frontArm.setSetpoint(setpoint);
		else
			roller.backArm.setSetpoint(setpoint);
		System.out.println("Front Roller Setpoint: " + roller.frontArm.getSetpoint());
	}
	
	protected void execute() {
		
	}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {
		System.out.println("Front Roller Setpoint: " + roller.frontArm.getSetpoint());
	}
	
	protected void interrupted() {
		
	}
	
}
