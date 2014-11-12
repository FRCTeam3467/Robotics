package org.usfirst.frc3467.subsystems.DriveBase3V3.commands;

import org.usfirst.frc3467.OI;
import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.subsystems.DriveBase3V3.DriveBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTurn extends CommandBase {
	DriveBase driveBase;
	int degrees = 0;
	double speed = 0.0;
	
	public DriveTurn(int degrees, double speed) {
		driveBase = DriveBase.getInstance();
		this.degrees = degrees;
		requires(driveBase);
		this.speed = speed;
		this.setTimeout(3);
	}
	
	protected void initialize() {
		driveBase.gyro.reset();
		driveBase.angle.setSetpoint(degrees);
		driveBase.angle.reset();
		driveBase.angle.enable();
		
		System.out.println("Turning: " + degrees);
		
		driveBase.distance.reset();
	}
	
	protected void execute() {
		driveBase.updateSD();
		
		if (DriveBase.debugging) {
			driveBase.angleTest.update();
		}
		driveBase.driveArcade(0, driveBase.gOutput.get());
	}
	
	protected boolean isFinished() {
		if (driveBase.distance.onTarget())
			System.out.println("On Target");
		if (manualSwitch())
			System.out.println("Manual Switch");
		if (this.isTimedOut())
			System.out.println("Timed Out");
		return driveBase.distance.onTarget() || manualSwitch() || this.isTimedOut();
	}
	
	private boolean manualSwitch() {
		return /*( Math.abs(OI.leftJoystick.getY()) > 0.2) ||*/ (Math.abs(OI.rightJoystick.getY()) > 0.2);
	}
	
	protected void end() {
		driveBase.angle.disable();
		driveBase.driveArcade(0, 0);
	}
	
	protected void interrupted() {
		end();
	}
}
