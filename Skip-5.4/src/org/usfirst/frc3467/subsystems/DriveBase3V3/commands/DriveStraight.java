package org.usfirst.frc3467.subsystems.DriveBase3V3.commands;

import org.usfirst.frc3467.OI;
import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.subsystems.DriveBase3V3.DriveBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveStraight extends CommandBase {
	DriveBase driveBase;
	int startTicks;
	int distance;
	int distanceInInches = 0;
	double speed = 0.0;
	boolean debug = false;
	
	public DriveStraight(int distanceInInches, double speed, boolean debug) {
		driveBase = DriveBase.getInstance();
		this.distanceInInches = distanceInInches;
		requires(driveBase);
		this.speed = speed;
		this.debug = debug;
		this.setTimeout(10);
		if (DriveBase.debugging) {
			SmartDashboard.putNumber("DS Timeout", 10);
			SmartDashboard.putNumber("Distance", 112);
		}
	}
	
	protected void initialize() {
		driveBase.gyro.reset();
		driveBase.angle.setSetpoint(0);
		driveBase.angle.reset();
		driveBase.angle.enable();
		
		if (!debug) {
			distance = distanceInInches;
		} else {
			distance = (int) SmartDashboard.getNumber("Distance", 112);
			speed = SmartDashboard.getNumber("Max Speed", 0.6);
		}
		System.out.println("Traveling: " + distance);
		
		driveBase.distance.reset();
		driveBase.distance.setSetpoint(distance * DriveBase.TICKS_PER_INCH);
		driveBase.distance.setOutputRange(-speed, speed);
		driveBase.distance.enable();
		
		startTicks = (int) driveBase.avgEnc.pidGet();
	}
	
	protected void execute() {
		this.setTimeout(SmartDashboard.getNumber("DS Timeout", 10));
		driveBase.updateSD();
		
		if (DriveBase.debugging) {
			driveBase.angleTest.update();
			driveBase.distanceTest.update();
		}
		driveBase.driveArcade(driveBase.dOutput.get(), driveBase.gOutput.get());
		if (DriveBase.debugging)
			SmartDashboard.putNumber("Distance Travled", (Math.abs(driveBase.avgEnc.pidGet()) - startTicks) / DriveBase.TICKS_PER_INCH);
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
		return (Math.abs(OI.rightJoystick.getY()) > 0.2);
	}
	
	protected void end() {
		driveBase.angle.disable();
		driveBase.distance.disable();
		driveBase.driveArcade(0, 0);
		if (DriveBase.debugging)
			SmartDashboard.putNumber("Distance Travled", (Math.abs(driveBase.avgEnc.pidGet()) - startTicks) / DriveBase.TICKS_PER_INCH);
	}
	
	protected void interrupted() {
		end();
	}
}
