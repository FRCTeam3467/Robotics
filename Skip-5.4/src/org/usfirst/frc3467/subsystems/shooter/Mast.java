package org.usfirst.frc3467.subsystems.shooter;

import org.usfirst.frc3467.commands.CommandBase;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Mast extends PIDSubsystem {
	private final static double PERIOD = 0.05;
	private Shooter shooter;
	
	public Mast(double p, double i, double d) {
		super(0, 0, 0, PERIOD, 0);
		shooter = CommandBase.shooter;
		lastAngle = shooter.pot.pidGet();
		lastTime = System.currentTimeMillis();
		// CommandBase.shooter.arm.setSetpoint(90);
		setpoint = 90;
	}
	
	protected double returnPIDInput() {
		return 0;
	}
	
	// Update values
	protected void usePIDOutput(double output) {
		// Link this setpoint to former PID controller
		// Temporary and saves a lot of time
		SmartDashboard.putNumber("Mast Setpoint", shooter.arm.getSetpoint());
		SmartDashboard.putNumber("Mast Error", shooter.arm.getError());
		if (shooter.arm.getSetpoint() > 90 + Shooter.potRange) {
			shooter.arm.setSetpoint(90 + Shooter.potRange);
		}
		if (shooter.arm.getSetpoint() < 90 - Shooter.potRange) {
			shooter.arm.setSetpoint(90 - Shooter.potRange);
		}
		setpoint = shooter.arm.getSetpoint();
		this.setSetpoint(setpoint);
		
		// Theta
		theta = shooter.pot.pidGet();
		
		// Delta time
		deltaTime = (double) (System.currentTimeMillis() - lastTime);
		lastTime = (double) System.currentTimeMillis();
		
		// Delta theta
		deltaTheta = theta - lastAngle;
		lastAngle = theta;
		
		// Speed
		speed = deltaTheta / deltaTime;
		deltaSpeed = speed - lastSpeed;
		
		finalSpeed = Math.sqrt(2.0 * SPEED_A * Math.abs(setpoint - theta));
		if (setpoint - theta < 0) {
			finalSpeed = -finalSpeed;
		}
		// System.out.println("Setpoint: " + setpoint);
		// System.out.println("Error: " + (setpoint - theta));
	}
	
	protected void initDefaultCommand() {
		
	}
	
	private double deltaTime = 0L;
	private double theta = 0.0;
	private double deltaTheta = 0.0;
	private double speed = 0.0;
	private double deltaSpeed = 0.0;
	private double finalSpeed = 0.0;
	private double setpoint = 0.0;
	
	// Holders
	private double lastTime = 0L;
	private double lastAngle = 0.0;
	private double lastSpeed = 0.0;
	
	// Constants
	public double TORQUE_C = 60.0;
	public double TORQUE_A = 0.03;
	public double SPEED_A = 5000.0;
	private static final double TORQUE_STALL = 0.81 * 660.0;
	private static final double SPEED_RATED = (1608.0 / 660.0) * 360.0 * 60.0;
	
	public double getDeltaTime() {
		return deltaTime;
	}
	
	public double getDeltaTheta() {
		return deltaTheta;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public double deltaSpeed() {
		return deltaSpeed;
	}
	
	public void setSetpoint(double setpoint) {
		shooter.arm.setSetpoint(setpoint);
	}
	
	public double getMotorOutput() {
		// Battery Ratio
		double batteryRatio = (12.0) / (DriverStation.getInstance().getBatteryVoltage());
		
		// Torque Ration
		double torqueRatio;
		// Hold arm
		torqueRatio = (Math.cos(Math.toRadians(theta)) * TORQUE_C) / (TORQUE_STALL);
		// Add speed
		torqueRatio += (((finalSpeed - speed) / deltaTime) * TORQUE_A);
		// System.out.println("Delta time: " + deltaTime);
		// System.out.println("A: " + (finalSpeed));
		// System.out.println("B: " + (finalSpeed - speed));
		// System.out.println("C: " + (finalSpeed - speed) / deltaTime);
		// System.out.println("D: " + (((finalSpeed - speed) / deltaTime) * TORQUE_A));
		// Speed ratio
		double speedRatio = (speed) / (SPEED_RATED);
		
		// Final output
		double dutyCycle = -(batteryRatio * (torqueRatio + speedRatio));
		
		// Prints
		// System.out.println("Theta: " + theta);
		// System.out.println("Bat: " + batteryRatio);
		// System.out.println("Torque C: " + TORQUE_C);
		// System.out.println("Torque A: " + TORQUE_A);
		// System.out.println("Speed A: " + TORQUE_A);
		// System.out.println("Tor: " + torqueRatio);
		// System.out.println("Speed: " + speedRatio);
		// System.out.println("Duty: " + dutyCycle);
		// System.out.println("---------------------------------------------------------------");
		return dutyCycle;
	}
	
	public double getLEDTheta() {
		return theta - lastAngle;
	}
	
	public double getError() {
		return Shooter.getInstance().arm.getSetpoint() - Shooter.getInstance().pot.pidGet();
	}
}
