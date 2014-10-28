package org.usfirst.frc3467.subsystems.shooter.commands.auto;

import org.usfirst.frc3467.commands.CommandBase;

public class UpdateArmAngle extends CommandBase {
	
	public UpdateArmAngle() {
		requires(kinect);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		kinect.armAngle = kinect.rightArm.getY();
		// System.out.println(kinect.armAngle);
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	}
	
}
