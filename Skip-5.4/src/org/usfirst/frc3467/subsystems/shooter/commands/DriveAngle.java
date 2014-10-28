package org.usfirst.frc3467.subsystems.shooter.commands;

import org.usfirst.frc3467.OI;
import org.usfirst.frc3467.RobotMap;
import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.other.Reverse;
import org.usfirst.frc3467.subsystems.shooter.Shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveAngle extends CommandBase {
	
	Shooter shooter;
	private final double fullSpeedRange = 15;// Degrees
	
	public DriveAngle() {
		shooter = Shooter.getInstance();
		requires(shooter);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		if (Shooter.debugging) {
			shooter.test.update();
			// SmartDashboard.putNumber("Pot", shooter.pot.pidGet());
			SmartDashboard.putNumber("Final Mast Output", shooter.angleMotor.get());
		}
		// Manually add joystick values to setpoint
		// Change setpoint by 5 degrees at most
		double maxDegrees = 2;
		double addSetpoint = 0;
		if (OI.opGamepadAuto.getDpadUp()) {
			if (!Reverse.reverse)
				addSetpoint += maxDegrees;
			else
				addSetpoint -= maxDegrees;
			shooter.frontSway = true;
			shooter.backSway = true;
		}
		if (OI.opGamepadAuto.getDpadDown()) {
			if (!Reverse.reverse)
				addSetpoint -= maxDegrees;
			else
				addSetpoint += maxDegrees;
			shooter.frontSway = true;
			shooter.backSway = true;
		}
		double setpoint = shooter.arm.getSetpoint() + addSetpoint;
		// Make sure setpoint is within range
		shooter.arm.setSetpoint(setpoint);
		
		int direction = 1;
		// Determine the direction that the arm will be moving
		if (shooter.arm.getError() > 0)
			direction = -direction;
		// If not within PID range
		if (shooter.pot.pidGet() > (shooter.arm.getSetpoint() + fullSpeedRange) || shooter.pot.pidGet() < (shooter.arm.getSetpoint() - fullSpeedRange)) {
			// Resets variables in PID and disables PID Controller
			if (shooter.arm.isEnable())
				shooter.arm.reset();
			// Drive motor at full speed in the correct direction
			shooter.angleMotor.set(RobotMap.armMaxSpeed * direction);
			// System.out.println("Full");
		} else { // If within range
			// Enable PID
			if (!shooter.arm.isEnable())
				shooter.arm.enable();
			// System.out.println("PID");
		}
	}
	
	protected boolean isFinished() {
		// Never finish!!! Can't have commands sleeping on the job.
		return false;
	}
	
	protected void end() {
		// If by any chance this command SOMEHOW were to end...
		// Then don't let it go ape shit
		shooter.arm.disable();
		shooter.angleMotor.set(0.0);
	}
	
	protected void interrupted() {
		// So help me god if this gets interupted, someonesAss.equals(kicked) returns true
		end();
	}
	
}
