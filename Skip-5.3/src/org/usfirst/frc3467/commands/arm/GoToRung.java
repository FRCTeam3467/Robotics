package org.usfirst.frc3467.commands.arm;

import org.usfirst.frc3467.RobotMap;
import org.usfirst.frc3467.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GoToRung extends CommandBase {
	int setPoint = 0;
	boolean eitherWay = false;
	
	public GoToRung(int setpoint, boolean biDirectional) {
		requires(arm);
		setPoint = setpoint;
		eitherWay = biDirectional;
	}
	
	protected void initialize() {
		arm.getPIDController().setSetpoint(setPoint);
		arm.disablePID();
		if (this.getGroup() == null) {
			CancelClimb.cancelClimb = false;
		} else if (this.getGroup().getGroup() == null) {
			CancelClimb.cancelClimb = false;
		}
	}
	
	protected void execute() {
		if (eitherWay) {
			arm.driveWinch(0.009 * (setPoint - arm.enc.getRaw()));
			// if (Math.abs(setPoint - arm.enc.getRaw()) < 200)
			// arm.enablePID();
		} else {
			if (arm.enc.getRaw() < RobotMap.maxEncCount)
				arm.driveWinch(0.009 * (RobotMap.maxEncCount - arm.enc.getRaw()));
			else
				arm.driveWinch(0.0);
			if (arm.enc.getRaw() > 1400)
				arm.extendPiston();
		}
	}
	
	protected boolean isFinished() {
		/*
		 * if (arm.enabled && arm.getPIDController().onTarget()) { SmartDashboard.putString("PID Status", "On target"); arm.disablePID(); arm.driveWinch(0.0); return true; } else
		 */
		if (CancelClimb.cancelClimb) {
			arm.driveWinch(0.0);
			return true;
		}
		if (Math.abs(setPoint - arm.enc.getRaw()) <= 25) {
			// arm.disablePID();
			arm.driveWinch(0.0); // Doug said code could have stopped executing... He was right
			return true;
		} else {
			SmartDashboard.putString("PID Status", "Not stopping");
			return false;
		}
	}
	
	protected void end() {
		System.out.println("Go to rung ended");
	}
	
	protected void interrupted() {
		
	}
	
}
