package org.usfirst.frc3467.subsystems.shooter;

import org.usfirst.frc3467.RobotMap;
import org.usfirst.frc3467.pid.Output;
import org.usfirst.frc3467.pid.PIDTest;
import org.usfirst.frc3467.subsystems.shooter.custom.CustomPot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
	public Talon angleMotor;
	public CustomPot pot;
	public PIDController arm;
	public Output motorOutput;
	
	public static final boolean debugging = true;
	public boolean frontSway = true;
	public boolean backSway = true;
	
	private static double Kp = 0.02;
	private static double Ki = 0.001;
	private static double Kd = 0.00;
	public static final double FORCE = 177.80826;
	public static final double TRAVEL = 40;
	public static final double MASS = 20;
	
	public static final int potRange = 40; // Degrees from 90
	
	private static Shooter instance;
	
	public static Shooter getInstance() {
		return instance;
	}
	
	public PIDTest test;
	
	public Shooter() {
		instance = this;
		angleMotor = new Talon(RobotMap.armAngle);
		motorOutput = new Output(angleMotor, true);
		pot = new CustomPot(RobotMap.armPot, (300 / 5));
		arm = new PIDController(Kp, Ki, Kd, pot, motorOutput);
		arm.disable();
		// arm.setOutputRange(-RobotMap.armMaxSpeed, RobotMap.armMaxSpeed);
		arm.setInputRange(90 - potRange, 90 + potRange);
		arm.setSetpoint(90);
		// CommandBasedRobot.PIDList.addElement(arm);
		// if (debugging)
		// test = new PIDTest("Arm", arm, false);
		
	}
	
	protected void initDefaultCommand() {
		// this.setDefaultCommand(new DriveAngle());
		this.setDefaultCommand(new DriveNew());
	}
	
}
