package org.usfirst.frc3467.subsystems.DriveBase3V3.commands;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.subsystems.DriveBase3V3.DriveBase;

public class ResetDBSensors extends CommandBase {
	
	protected void initialize() {
		DriveBase.getInstance().gyro.reset();
		DriveBase.getInstance().leftSideEnc.reset();
		DriveBase.getInstance().rightSideEnc.reset();
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
