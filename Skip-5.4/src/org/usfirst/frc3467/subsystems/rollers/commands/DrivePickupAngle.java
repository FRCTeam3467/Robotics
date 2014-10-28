package org.usfirst.frc3467.subsystems.rollers.commands;

import org.usfirst.frc3467.OI;
import org.usfirst.frc3467.RobotMap;
import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.other.Reverse;
import org.usfirst.frc3467.subsystems.rollers.Roller;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DrivePickupAngle extends CommandBase {
	
	Roller roller;
	
	public DrivePickupAngle() {
		roller = Roller.getInstance();
		requires(roller);
	}
	
	protected void initialize() {
		if (Roller.debugging) {
			// Front
			SmartDashboard.putNumber("Front Power", 0.3);
			// Back
			SmartDashboard.putNumber("Back Power", 0.3);
		}
		roller.backArm.enable();
		roller.frontArm.enable();
	}
	
	protected void execute() {
		if (Roller.debugging) {
			// Front Roller
			SmartDashboard.putNumber("Back Arm Input", roller.backPot.pidGet());
			SmartDashboard.putNumber("Front Arm Input", roller.frontPot.pidGet());
			SmartDashboard.putNumber("Front Pot Raw", roller.frontPot.getAverageVoltage());
			// SmartDashboard.putNumber("Back Pot Raw", roller.backPot.pidGet());
			roller.frontTest.update();
			// SmartDashboard.putNumber("Pot", roller.frontPot.pidGet());
			// SmartDashboard.putNumber("Final Output", roller.frontMotor.get());
			RobotMap.pickUpMaxSpeed = SmartDashboard.getNumber("Front Power", 0.3);
			
			// Back Roller
			roller.backTest.update();
			// SmartDashboard.putNumber("Back Pot", roller.backPot.pidGet());
			// SmartDashboard.putNumber("Back Final Output", roller.backMotor.get());
			RobotMap.pickUpMaxSpeed = SmartDashboard.getNumber("Back Power", 0.3);
		}
		
		// FRONT ROLLERS
		// Manually add joystick values to setpoint
		// Change setpoint by MAX_DEGREES degrees at most
		final double MAX_DEGREES = 1; // Speed of manual change in setpoint
		// Direction of motors in case they need to be reversed for full speed movement
		int frontDirection = -1;
		
		if (Reverse.reverse) {
			if (Math.abs(OI.opGamepadAuto.getRightStickY()) > 0.3)
				shooter.backSway = false;
			if (Math.abs(OI.opGamepadAuto.getLeftStickY()) > 0.3)
				shooter.frontSway = false;
		} else {
			if (Math.abs(OI.opGamepadAuto.getLeftStickY()) > 0.3)
				shooter.backSway = false;
			if (Math.abs(OI.opGamepadAuto.getRightStickY()) > 0.3)
				shooter.frontSway = false;
		}
		
		final int BUFFER = 18; // Degrees
		double shooterAngle = (shooter.pot.pidGet() + shooter.arm.getSetpoint()) / 2;
		if (Roller.frontRoller) {
			if (shooter.frontSway) {
				// Sets the roller setpoint to a distance away from the mast to avoid collision
				roller.frontArm.setSetpoint((180 - shooterAngle) - BUFFER);
				
			} else {
				double old = roller.frontArm.getSetpoint();
				double frontSetpoint = roller.frontArm.getSetpoint();
				if (!Reverse.reverse) {
					if (Math.abs(OI.opGamepadAuto.getRightStickY()) > 0.1)
						frontSetpoint += (OI.opGamepadAuto.getRightStickY() * MAX_DEGREES);
				} else {
					if (Math.abs(OI.opGamepadAuto.getLeftStickY()) > 0.1)
						frontSetpoint += (OI.opGamepadAuto.getLeftStickY() * MAX_DEGREES);
				}
				
				// Sets the setpoint of the front roller
				if (old != frontSetpoint)
					roller.frontArm.setSetpoint(frontSetpoint);
				
				// Determine the direction that the arm will be moving
				if (roller.frontArm.getError() < 0)
					frontDirection = -frontDirection;
				// If not within PID range
				if (roller.frontPot.pidGet() > (roller.frontArm.getSetpoint() + Roller.frontPotRange) || roller.frontPot.pidGet() < (roller.frontArm.getSetpoint() - Roller.frontPotRange)) {
					// Resets variables in PID and disables PID Controller
					if (roller.frontArm.isEnable())
						roller.frontArm.reset();
					// Drive motor at full speed in the correct direction
					roller.frontMotor.set(RobotMap.pickUpMaxSpeed * frontDirection);
					System.out.println("FrontRoller Full");
				} else { // If within range
					// Enable PID
					if (!roller.frontArm.isEnable())
						roller.frontArm.enable();
				}
			}
		}
		
		// BACK ROLLERS
		// Manually add joystick values to setpoint
		// Change setpoint by MAX_DEGREES degrees at most
		// Direction of motors in case they need to be reversed for full speed movement
		int backDirection = 1;
		if (Roller.backRoller) {
			if (shooter.backSway) {
				// Sets the roller setpoint to a distance away from the mast to avoid collision
				roller.backArm.setSetpoint(shooterAngle - BUFFER);
			} else {
				double backSetpoint = roller.backArm.getSetpoint();
				if (!Reverse.reverse) {
					if (Math.abs(OI.opGamepadAuto.getLeftStickY()) > 0.1)
						backSetpoint += (OI.opGamepadAuto.getLeftStickY() * MAX_DEGREES);
				} else {
					if (Math.abs(OI.opGamepadAuto.getRightStickY()) > 0.1)
						backSetpoint += (OI.opGamepadAuto.getRightStickY() * MAX_DEGREES);
				}
				
				// Sets the setpoint of the rear roller
				roller.backArm.setSetpoint(backSetpoint);
				
				// Determine the direction that the arm will be moving
				if (roller.backArm.getError() < 0)
					frontDirection = -backDirection;
				// If not within PID range
				if (roller.backPot.pidGet() > (roller.backArm.getSetpoint() + Roller.backPotRange) || roller.backPot.pidGet() < (roller.backArm.getSetpoint() - Roller.backPotRange)) {
					// Resets variables in PID and disables PID Controller
					if (roller.backArm.isEnable())
						roller.backArm.reset();
					// Drive motor at full speed in the correct direction
					roller.backMotor.set(RobotMap.pickUpMaxSpeed * backDirection);
					System.out.println("Back Roller Full");
				} else { // If within range
					// Enable PID
					if (!roller.backArm.isEnable())
						roller.backArm.enable();
				}
			}
		}
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	}
}
