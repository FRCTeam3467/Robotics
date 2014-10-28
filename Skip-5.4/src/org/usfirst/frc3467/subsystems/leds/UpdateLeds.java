package org.usfirst.frc3467.subsystems.leds;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.other.Reverse;
import org.usfirst.frc3467.subsystems.DriveBase3V3.DriveBase;

public class UpdateLeds extends CommandBase {
	public UpdateLeds() {
		requires(leds);
	}
	
	protected void initialize() {
		
	}
	
	boolean lastState = false;
	
	protected void execute() {
		if (lastState != Reverse.reverse) {
			if (Reverse.reverse) {
				CommandBase.leds.setState("Reverse", Leds.REG1, 1);
			} else {
				CommandBase.leds.setState("Reverse", Leds.REG1, 0);
			}
		}
		if (DriveBase.getInstance().mainBreaker.getCurrent() < 150.0) {
			if (!Reverse.reverse) {
				if (Math.abs(mast.getError()) < 1.5) {
					if (shooter.arm.getSetpoint() == 130.0) {
						CommandBase.leds.setState("Mast 130", Leds.ONE_THIRTY);
					}
					if (shooter.arm.getSetpoint() == 123.0) {
						CommandBase.leds.setState("Mast 122", Leds.TRUSS);
					}
					if (shooter.arm.getSetpoint() == 116.0) {
						CommandBase.leds.setState("Mast 115", Leds.CLOSE);
					}
					if (shooter.arm.getSetpoint() == 100.0) {
						CommandBase.leds.setState("Mast 100", Leds.TRUSS2);
					}
				}
			} else {
				if (Math.abs(mast.getError()) < 1.0) {
					if (shooter.arm.getSetpoint() == 50.0) {
						CommandBase.leds.setState("Mast 50", Leds.ONE_THIRTY);
					}
					if (shooter.arm.getSetpoint() == 59.0) {
						CommandBase.leds.setState("Mast 58", Leds.TRUSS);
					}
					if (shooter.arm.getSetpoint() == 66.0) {
						CommandBase.leds.setState("Mast 65", Leds.CLOSE);
					}
					if (shooter.arm.getSetpoint() == 80.0) {
						CommandBase.leds.setState("Mast 80", Leds.TRUSS2);
					}
				}
			}
			/*
			 * if (rollies.rollerFront.get() > 0) { CommandBase.leds.setState("Rollers", Leds.REG5, 1); } else if (rollies.rollerBack.get() < 0) { CommandBase.leds.setState("Rollers", Leds.REG5, 2); } else { CommandBase.leds.setState("Rollers", Leds.REG5, 0); }
			 */
		} else {
			CommandBase.leds.setState("Current", Leds.HIGH_CURRENT);
		}
		lastState = Reverse.reverse;
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	}
	
}
