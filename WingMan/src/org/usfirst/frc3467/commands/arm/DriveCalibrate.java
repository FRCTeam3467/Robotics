package org.usfirst.frc3467.commands.arm;

import org.usfirst.frc3467.RobotMap;
import org.usfirst.frc3467.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveCalibrate extends CommandBase {
	
	public DriveCalibrate() {
		requires(arm);
		arm.disablePID();
		this.setInterruptible(false);
		this.setTimeout(3);
	}
	
	protected void end() {
		// System.out.println("Arm Calibrated");
	}
	
	protected void execute() {
		arm.driveWinch(-RobotMap.winchCalibrateSpeed);
	}
	
	protected void initialize() {
		arm.retractPiston();
	}
	
	protected void interrupted() {
		
	}
	
	protected boolean isFinished() {
		// Read the limit switch state
		boolean limitTriggered = arm.limitSwitch.get();
		if (!limitTriggered || isTimedOut()) {
			if (isTimedOut())
				SmartDashboard.putString("Arm Calibration", "Timed out!");
			else
				SmartDashboard.putString("Arm Calibration", "Calibrated");
			arm.enc.reset();
			arm.idle();
			return true;
		} else {
			return false;
		}
	}
	
}
