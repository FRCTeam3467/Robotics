package org.usfirst.frc3467.subsystems.shooter.commands;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.subsystems.rollers.commands.SetRoller;

import edu.wpi.first.wpilibj.command.Scheduler;

public class ReturnAll extends CommandBase {
	
	public ReturnAll() {
		requires(shooter);
		requires(roller);
	}
	
	protected void initialize() {
		// Disable sway
		shooter.frontSway = false;
		shooter.backSway = false;
		// Return to 90
		shooter.arm.setSetpoint(90.0);
		roller.backArm.setSetpoint(90.0);
		roller.frontArm.setSetpoint(90.0);
		roller.backArm.enable();
		roller.frontArm.enable();
		Scheduler.getInstance().add(new SetRoller(0.0, true));
		Scheduler.getInstance().add(new SetRoller(0.0, false));
	}
	
	protected void execute() {
		shooter.arm.setSetpoint(90.0);
		roller.backArm.setSetpoint(90.0);
		roller.frontArm.setSetpoint(90.0);
	}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	}
	
}
