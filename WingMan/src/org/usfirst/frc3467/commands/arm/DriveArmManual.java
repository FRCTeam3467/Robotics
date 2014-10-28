package org.usfirst.frc3467.commands.arm;

import org.usfirst.frc3467.OI;
import org.usfirst.frc3467.RobotMap;
import org.usfirst.frc3467.commands.CommandBase;

public class DriveArmManual extends CommandBase {
	
	public DriveArmManual() {
		requires(arm);
	}
	
	protected void initialize() {
		
	}
	
	double maxSpeed = 0.0;	// Create a maximum speed the arm can move at different points
	double cons = 0.005; 	// 200 ticks away is full power
	
	protected void execute() {
		boolean up = false;
		
		// Don't bother doing anything if the joystick isn't being moved at least 20% of its range
		if (Math.abs(OI.operatorJoystick.getY()) > 0.2) {
			if (OI.operatorJoystick.getY() > 0.0) 	// If the joystick is being pulled back
				up = true; 							// The operator wants the arm up
			else
				up = false;							// Else the operator wants the arm down
				
			if (!arm.getPidStatus()) {
				if (up)
					maxSpeed = (cons * (RobotMap.maxEncCount - arm.enc.getRaw()));
				else
					maxSpeed = (RobotMap.armConstant * (0 + arm.enc.getRaw()));
				if (maxSpeed > 1.0)
					maxSpeed = 1.0;
				else if (maxSpeed < -1.0)
					maxSpeed = -1.0; // System.out.println("Driving");
				if (OI.operatorJoystick.getY() <= maxSpeed && !up)
					arm.driveWinch(maxSpeed);
				else if (OI.operatorJoystick.getY() >= maxSpeed && up)
					arm.driveWinch(maxSpeed);
				else
					arm.driveWinch(OI.operatorJoystick.getY());
			}
		} else {
			arm.idle();
			// System.out.println("Idling");
		}
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
	}
}
