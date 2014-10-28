package org.usfirst.frc3467.subsystems.shooter.commands;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.other.Reverse;
import org.usfirst.frc3467.subsystems.shooter.Shooter;

public class SetSetpoint extends CommandBase {
	
	private double setpoint;
	boolean button;
	
	public SetSetpoint(double setpoint, boolean button) {
		if (setpoint > 90 + Shooter.potRange)
			setpoint = 90 + Shooter.potRange;
		else if (setpoint < 90 - Shooter.potRange)
			setpoint = 90 - Shooter.potRange;
		this.setpoint = setpoint;
		this.button = button;
	}
	
	protected void initialize() {
		if (!Reverse.reverse)
			shooter.arm.setSetpoint(setpoint);
		else
			shooter.arm.setSetpoint(180 - setpoint);
		if (button) {
			shooter.frontSway = true;
			shooter.backSway = true;
		}
	}
	
	protected void execute() {
		
	}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {
		System.out.println("Setting Setpoint: " + setpoint);
	}
	
	protected void interrupted() {
		
	}
	
}
