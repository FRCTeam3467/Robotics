package org.usfirst.frc3467.subsystems.rollers;

import org.usfirst.frc3467.CommandBasedRobot;
import org.usfirst.frc3467.RobotMap;
import org.usfirst.frc3467.pid.Output;
import org.usfirst.frc3467.pid.PIDTest;
import org.usfirst.frc3467.subsystems.rollers.commands.DrivePickupAngle;
import org.usfirst.frc3467.subsystems.rollers.custom.CustomPot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Roller extends Subsystem {
	public Talon frontMotor;
	public Talon backMotor;
	
	public CustomPot frontPot;
	public CustomPot backPot;
	public PIDController frontArm;
	public PIDController backArm;
	public PIDTest frontTest;
	public PIDTest backTest;
	public Output frontMotorOutput;
	public Output backMotorOutput;
	
	public static final boolean frontRoller = true;
	public static final boolean backRoller = true;
	
	public static final boolean debugging = true;
	
	private static double Kp = 0.03;
	private static double Ki = 0.00;
	private static double Kd = 0.00;
	
	public static final int frontPotRange = 48; // Degrees from 90
	public static final int backPotRange = 48; // Degrees from 90
	
	private static Roller instance;
	
	public static Roller getInstance() {
		return instance;
	}
	
	public Roller() {
		instance = this;
		
		frontMotor = new Talon(RobotMap.pickupTalonFront);
		frontMotorOutput = new Output(frontMotor, true);
		frontPot = new CustomPot(RobotMap.rollerFrontPot, 30.0);
		// frontPot = new AnalogChannel(RobotMap.rollerFrontPot);
		frontArm = new PIDController(Kp, Ki, Kd, frontPot, frontMotorOutput);
		frontArm.setOutputRange(-RobotMap.pickUpMaxSpeed, RobotMap.pickUpMaxSpeed);
		frontArm.setInputRange(90 - frontPotRange, 90);
		frontArm.setSetpoint(90);
		CommandBasedRobot.PIDList.addElement(frontArm);
		frontTest = new PIDTest("Front Pickup Arm", frontArm, false);
		
		backMotor = new Talon(RobotMap.pickupTalonBack);
		backMotorOutput = new Output(backMotor, false);
		backPot = new CustomPot(RobotMap.rollerBackPot, ((255.0 / 5.0) * (11.0 / 22.0)));
		backArm = new PIDController(Kp, Ki, Kd, backPot, backMotorOutput);
		backArm.setOutputRange(-RobotMap.pickUpMaxSpeed, RobotMap.pickUpMaxSpeed);
		backArm.setInputRange(90 - backPotRange, 90);
		backArm.setSetpoint(90);
		CommandBasedRobot.PIDList.addElement(backArm);
		backTest = new PIDTest("Back Pickup Arm", backArm, false);
	}
	
	protected void initDefaultCommand() {
		this.setDefaultCommand(new DrivePickupAngle());
	}
	
}
