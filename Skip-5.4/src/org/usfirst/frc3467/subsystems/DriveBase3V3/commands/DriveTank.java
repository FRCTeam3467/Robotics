package org.usfirst.frc3467.subsystems.DriveBase3V3.commands;

import org.usfirst.frc3467.OI;
import org.usfirst.frc3467.RobotMap;
import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.other.Reverse;
import org.usfirst.frc3467.subsystems.DriveBase3V3.DriveBase;

public class DriveTank extends CommandBase {
	
	private DriveBase driveBase;
	
	public DriveTank() {
		driveBase = DriveBase.getInstance();
		requires(driveBase);
		this.setInterruptible(true);
	}
	
	protected void end() {
		
	}
	
	protected void execute() {
		if (!Reverse.reverse)
			driveBase.driveTank(/*OI.leftJoystick.getY(),*/OI.rightJoystick.getY(), OI.rightJoystick.getY());
		else
			driveBase.driveTank(-OI.rightJoystick.getY(), -OI.rightJoystick.getY()); //, -OI.leftJoystick.getY());
		RobotMap.updateSensors();
	}
	
	protected void initialize() {
		
	}
	
	protected void interrupted() {
		end();
	}
	
	protected boolean isFinished() {
		return false;
	}
	
}
