package org.usfirst.frc3467.commands.drivebase;

import org.usfirst.frc3467.OI;
import org.usfirst.frc3467.commands.CommandBase;

public class DriveJoysticks extends CommandBase {

	public DriveJoysticks() {
		requires(driveBase);			// Requires drive base subsystem
	}

	protected void initialize() {

	}

	protected void execute() {
		double left = 0.0;
		double right = 0.0;
		left = OI.leftJoystick.getY();	// Set left speed to left joystick
		right = OI.rightJoystick.getY();// Set right speed to right joystick
		driveBase.drive(left, right);	// Tell the robot to execute with new values
	}

	protected void interrupted() {

	}

	protected void end() {

	}

	protected boolean isFinished() {
		return false;
	}

}
