package org.usfirst.frc3467.subsystems.shooter;

import org.usfirst.frc3467.OI;
import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.other.Reverse;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveNew extends CommandBase {
	
	public DriveNew() {
		requires(mast);
		requires(shooter);
		// this.setInterruptible(false);
	}
	
	protected void initialize() {
		SmartDashboard.putNumber("TORQUE_C", mast.TORQUE_C);
		SmartDashboard.putNumber("TORQUE_A", mast.TORQUE_A);
		SmartDashboard.putNumber("SPEED_A", mast.SPEED_A);
		mast.enable();
	}
	
	protected void execute() {
		double speed1 = 4;
		double speed2 = 1;
		double addSetpoint = 0;
		if (OI.opGamepadAuto.getDpadUp()) {
			if (!Reverse.reverse)
				addSetpoint += speed1;
			else
				addSetpoint -= speed1;
			shooter.frontSway = true;
			shooter.backSway = true;
		}
		if (OI.opGamepadAuto.getDpadLeft()) {
			if (!Reverse.reverse)
				addSetpoint += speed2;
			else
				addSetpoint -= speed2;
			shooter.frontSway = true;
			shooter.backSway = true;
		}
		if (OI.opGamepadAuto.getDpadDown()) {
			if (!Reverse.reverse)
				addSetpoint -= speed1;
			else
				addSetpoint += speed1;
			shooter.frontSway = true;
			shooter.backSway = true;
		}
		if (OI.opGamepadAuto.getDpadRight()) {
			if (!Reverse.reverse)
				addSetpoint -= speed2;
			else
				addSetpoint += speed2;
			shooter.frontSway = true;
			shooter.backSway = true;
		}
		shooter.arm.setSetpoint(shooter.arm.getSetpoint() + addSetpoint);
		mast.TORQUE_C = SmartDashboard.getNumber("TORQUE_C");
		mast.TORQUE_A = SmartDashboard.getNumber("TORQUE_A");
		mast.SPEED_A = SmartDashboard.getNumber("SPEED_A");
		shooter.angleMotor.set(mast.getMotorOutput());
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		System.out.println("Mast control interupted");
	}
	
}
