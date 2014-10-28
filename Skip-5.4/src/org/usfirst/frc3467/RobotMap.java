package org.usfirst.frc3467;

import org.usfirst.frc3467.subsystems.shooter.Shooter;
import org.usfirst.frc3467.subsystems.shooter.Winch;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotMap {
	
	// PWM Out
	public static final int dbRight = 2; // ////////// Right Drive Base Talon
	public static final int dbLeft = 3; // /////////// Left Drive Base Talon
	public static final int armAngle = 4; // ///////// Mast Angle Talon
	public static final int winch = 5; // //////////// Shooter Winch Talon
	public static final int rollerTalonBack = 6; // // Back Pickup Roller Talon
	public static final int pickupTalonBack = 7; // // Back Pickup Angle Talon
	public static final int rollerTalonFront = 8; // / Front Pickup Roller Talon
	public static final int pickupTalonFront = 9; // / Front Pickup Angle Talon
	
	// Solenoid
	public static final int shiftDown = 1;
	public static final int shiftUp = 2;
	public static final int winchBrakeLock = 3;
	public static final int winchBrakeRelease = 4;
	public static final int winchShiftIn = 5;
	public static final int winchShiftOut = 6;
	
	// Analog
	public static final int dbGyro = 1; // ////////// Gyro
	public static final int armPot = 2; // ////////// Mast Pot
	public static final int rollerBackPot = 3; // /// Back Pickup Angle Pot
	public static final int rollerFrontPot = 4; // // Front Pickup Angle Pot
	public static final int winchPot = 5; // //////// Shooter Winch Pot
	public static final int mainCurrent = 6; // ///// Main Breaker Current (200 Amps)
	
	// Relay
	public static final int comperessorSpike = 1;
	
	// Digital I/0
	public static final int compressorPressureSwitch = 1;
	public static final int driveBaseLeftEncoderA = 2;
	public static final int driveBaseLeftEncoderB = 3;
	public static final int driveBaseRightEncoderA = 4;
	public static final int driveBaseRightEncoderB = 5;
	
	// I2C
	// I dunno. You figure it out
	
	// Constants
	public static final double armMaxSpeed = 0.5;
	public static double pickUpMaxSpeed = 0.3;
	public static double softShotSpeed = 0.2;
	
	public static void updateSensors() {
		SmartDashboard.putNumber("Winch Pot", Winch.getInstance().pot.pidGet());
		SmartDashboard.putNumber("Arm Pot", Shooter.getInstance().pot.pidGet());
		// SmartDashboard.putNumber("Back Pickup Pot", RollerBack.getInstance().pot.pidGet());
		// SmartDashboard.putNumber("Front Pickup Pot", Roller.getInstance().frontPot.pidGet());
		// SmartDashboard.putNumber("Front Pickup Pot", Roller.getInstance().frontPot.get());
	}
	
}
