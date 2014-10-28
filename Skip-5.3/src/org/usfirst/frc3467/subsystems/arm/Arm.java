package org.usfirst.frc3467.subsystems.arm;

import org.usfirst.frc3467.RobotMap;
import org.usfirst.frc3467.commands.arm.DriveArmManual;
import org.usfirst.frc3467.commands.arm.DriveCalibrate;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm extends PIDSubsystem {
	
	public Solenoid extendPiston; 							// Declares solenoid 1
	public Solenoid retractPiston; 							// Declares solenoid 2
	public DigitalInput limitSwitch; 						// Declares the digital input
	public Encoder enc; 									// Declares the encoder
	private Talon talon; 									// Declares the talon
	public boolean enabled = false;								// Declares class variable
	
	private static final double Kp = 0.005;					// Numbers are so small because the raw
	private static final double Ki = 0.002;					// encoder data is so large
	private static final double Kd = 0.0001;
	
	public Arm() {
		super(Kp, Ki, Kd);										// Feed PID values to PID Controller
		enc = new Encoder(RobotMap.armEncA, RobotMap.armEncB); 	// Create new encoder instance
		enc.start();											// Start reading from the encoder
		talon = new Talon(RobotMap.armTalon);					// Create new talon instance
		limitSwitch = new DigitalInput(RobotMap.limitSwith);	// Create new limit switch instance
		extendPiston = new Solenoid(RobotMap.armPistonDown);	// Create new solenoid instance for extending the arm
		retractPiston = new Solenoid(RobotMap.armPistonUp);		// Create new solenoid instance for retracting the arm
		disablePID();											// Disable the PID subsystem to start
		this.setInputRange(0, 2100);							// Set the input range
		this.setAbsoluteTolerance(15);							// Set tolerance for onTarget()
		setSetpoint(0);											// Set the set point to zero
		// initialize();
	}
	
	public void initialize() {
		Scheduler.getInstance().add(new DriveCalibrate());
	}
	
	protected double returnPIDInput() {
		int ticks = enc.getRaw(); 								// Get raw encoder ticks
		SmartDashboard.putNumber("Arm Encoder Raw", ticks);		// Put raw encoder data to SmartDashboard for monitoring
		return ticks;											// Return ticks to the PID controller
	}
	
	protected void usePIDOutput(double output) {
		driveWinch(output);										// Drive the winch with PID result
	}
	
	protected void initDefaultCommand() {
		// Scheduler.getInstance().add(new DriveCalibrate());
		setDefaultCommand(new DriveArmManual());				// Always drive the arm manually unless PID is enabled
	}
	
	public boolean getPidStatus() {
		return enabled;											// Return whether the PID subsytem is enabled or not
	}
	
	public void driveWinch(double percentPower) {
		if (!limitSwitch.get())
			enc.reset();
		talon.set(-percentPower);								// Invert power to account for electrical/mechanical setup
		SmartDashboard.putNumber("Arm Power", percentPower);
		SmartDashboard.putNumber("Arm Encoder", enc.getRaw());
	}
	
	public void idle() {
		driveWinch(0);											// Idle the motor so it doesn't move
	}
	
	public void disablePID() {
		disable();												// Disabled the PID subsystem
		enabled = false;										// Mark class variable
		SmartDashboard.putBoolean("PID Enabled", enabled);		// Put enabled status to SmartDashboard
	}
	
	public void enablePID() {
		enable();												// Enabled the PID subsystem
		enabled = true;											// Mark class variable
		SmartDashboard.putBoolean("PID Enabled", enabled);		// Put enabled status to SmartDashboard
	}
	
	public void retractPiston() {
		retractPiston.set(false);								// Set solenoid valves to put arm down
		extendPiston.set(true);
	}
	
	public void extendPiston() {
		retractPiston.set(true);								// Set solenoid valves to put arm up
		extendPiston.set(false);
	}
}
