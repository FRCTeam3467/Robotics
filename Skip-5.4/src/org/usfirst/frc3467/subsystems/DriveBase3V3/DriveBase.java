package org.usfirst.frc3467.subsystems.DriveBase3V3;

import org.usfirst.frc3467.CommandBasedRobot;
import org.usfirst.frc3467.RobotMap;
import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.other.Current;
import org.usfirst.frc3467.pid.Input;
import org.usfirst.frc3467.pid.Output;
import org.usfirst.frc3467.pid.PIDTest;
import org.usfirst.frc3467.subsystems.DriveBase3V3.commands.DriveStraight;
import org.usfirst.frc3467.subsystems.DriveBase3V3.commands.DriveTank;
import org.usfirst.frc3467.subsystems.DriveBase3V3.commands.ResetDBSensors;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveBase extends Subsystem {
	
	public static final boolean debugging = true;
	
	public Talon left;
	public Talon right;
	
	public Encoder leftSideEnc;
	public Encoder rightSideEnc;
	public Gyro gyro;
	
	public Current mainBreaker;
	
	public static final double TICKS_PER_REV = 3840;
	public static final double WHEEL_DIAMETER = 4;
	public static final double TICKS_PER_INCH = (TICKS_PER_REV / (WHEEL_DIAMETER * Math.PI)); // 224.2
	
	private static final double Gp = 0.1;
	private static final double Gi = 0.001;
	private static final double Gd = 0.0;
	
	private static final double Dp = 0.9;
	private static final double Di = 0.000;
	private static final double Dd = 0.001;
	
	private RobotDrive drive;
	
	public PIDController angle;
	public PIDTest angleTest;
	
	public PIDController distance;
	public PIDTest distanceTest;
	
	private Solenoid shiftDown;
	private Solenoid shiftUp;
	
	public Output lOutput;
	public Output rOutput;
	public Output gOutput;
	public Output dOutput;
	
	public Input avgEnc;
	
	private static DriveBase instance;
	
	public static DriveBase getInstance() {
		return instance;
	}
	
	protected void initDefaultCommand() {
		this.setDefaultCommand(new DriveTank());
	}
	
	public DriveBase() {
		instance = this;
		
		left = new Talon(RobotMap.dbLeft);
		right = new Talon(RobotMap.dbRight);
		
		shiftDown = new Solenoid(RobotMap.shiftDown);
		shiftUp = new Solenoid(RobotMap.shiftUp);
		
		if (debugging) {
			SmartDashboard.putNumber("Max Speed", 0.6);
		}
		
		leftSideEnc = new Encoder(RobotMap.driveBaseLeftEncoderA, RobotMap.driveBaseLeftEncoderB);
		leftSideEnc.setDistancePerPulse(1 / TICKS_PER_INCH);
		leftSideEnc.setPIDSourceParameter(PIDSourceParameter.kRate);
		leftSideEnc.setReverseDirection(false);
		leftSideEnc.start();
		
		rightSideEnc = new Encoder(RobotMap.driveBaseRightEncoderA, RobotMap.driveBaseRightEncoderB);
		rightSideEnc.setDistancePerPulse(1 / TICKS_PER_INCH);
		rightSideEnc.setPIDSourceParameter(PIDSourceParameter.kRate);
		rightSideEnc.setReverseDirection(true);
		rightSideEnc.start();
		
		gyro = new Gyro(RobotMap.dbGyro);
		
		lOutput = new Output(left, false);
		rOutput = new Output(right, true);
		gOutput = new Output();
		dOutput = new Output(true);
		
		avgEnc = new Input(0);
		avgEnc.addEncoder(leftSideEnc);
		avgEnc.addEncoder(rightSideEnc);
		
		drive = new RobotDrive(lOutput, rOutput);
		drive.setSafetyEnabled(false);
		
		angle = new PIDController(Gp, Gi, Gd, gyro, gOutput);
		angle.setContinuous();
		angle.setAbsoluteTolerance(4);
		angle.setInputRange(0, 359);
		CommandBasedRobot.PIDList.addElement(angle);
		
		distance = new PIDController(Dp, Di, Dd, avgEnc, dOutput);
		distance.setAbsoluteTolerance(4 * TICKS_PER_INCH);
		if (debugging) {
			angleTest = new PIDTest("Gyro", angle, false);
			distanceTest = new PIDTest("Distance", distance, false);
		}
		
		mainBreaker = new Current(RobotMap.mainCurrent);
		
		if (debugging) {
			SmartDashboard.putData("Drive Straight", new DriveStraight(0, 0.6, true));
			SmartDashboard.putData("Reset Sensors", new ResetDBSensors());
		}
	}
	
	// Use arcade mode to drive
	public void driveArcade(double speed, double angle) {
		drive.arcadeDrive(speed, angle);
		updateSD();
	}
	
	// Use standard tank drive
	public void driveTank(double left, double right) {
		drive.tankDrive(left, right);
		
		updateSD();
	}
	
	// Refresh Smart Dashboard values
	public void updateSD() {
		if (debugging) {
			SmartDashboard.putNumber("Gyro", gyro.getAngle());
			// Print data to smart dashboard
			SmartDashboard.putNumber("Left Encoder", leftSideEnc.getRaw());
			SmartDashboard.putNumber("Right Encoder", rightSideEnc.getRaw());
			
			SmartDashboard.putNumber("LeftMotorOutput", left.get());
			SmartDashboard.putNumber("RightMotorOutput", right.get());
			
			// Print data to smart dashboard
			SmartDashboard.putNumber("LeftSpeed", leftSideEnc.getRate());
			SmartDashboard.putNumber("RightSpeed", rightSideEnc.getRate());
			SmartDashboard.putNumber("AvgSpeed", (rightSideEnc.getRate() + leftSideEnc.getRate()) / 2);
		}
		SmartDashboard.putNumber("Main Breaker", mainBreaker.getCurrent());
		SmartDashboard.putNumber("Distance to wall raw", CommandBase.ultrasonics.getDistance());
		SmartDashboard.putNumber("Distance to wall median", CommandBase.ultrasonics.getMedianDistance());
		// SmartDashboard.putNumber("Main Breaker", mainBreaker.getCurrent());
	}
	
	// Down shift
	public void shiftDown() {
		shiftDown.set(true);
		shiftUp.set(false);
	}
	
	// Up shift
	public void shiftUp() {
		shiftDown.set(false);
		shiftUp.set(true);
	}
}
