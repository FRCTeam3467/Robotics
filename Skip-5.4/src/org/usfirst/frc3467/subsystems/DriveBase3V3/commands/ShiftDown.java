package org.usfirst.frc3467.subsystems.DriveBase3V3.commands;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.subsystems.DriveBase3V3.DriveBase;

public class ShiftDown extends CommandBase {
	
	public ShiftDown() {
		
	}
	
	protected void initialize() {
		System.out.println("Shift Down");
		DriveBase.getInstance().shiftDown();
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
