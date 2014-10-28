package org.usfirst.frc3467.subsystems.drivebase;

import org.usfirst.frc3467.RobotMap;
import org.usfirst.frc3467.commands.drivebase.DriveJoysticks;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveBase extends Subsystem {
	private RobotDrive drive;
	private Victor leftVictors, rightVictors;
	
	public DriveBase() {
		leftVictors = new Victor(RobotMap.leftTalons); // defines the left victor based on the
														// robotmap
		rightVictors = new Victor(RobotMap.rightTalons); // defines the right victor based on the
															// robotmap
		drive = new RobotDrive(leftVictors, rightVictors); // establishes the drive command
		drive.setSafetyEnabled(false); // disables the safety
	}
	
	public void drive(double left, double right) {
		drive.tankDrive(left, right); // creates tank drive
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new DriveJoysticks());
	}
}
