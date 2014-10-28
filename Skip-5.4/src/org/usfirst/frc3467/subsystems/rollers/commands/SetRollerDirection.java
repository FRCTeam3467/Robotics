package org.usfirst.frc3467.subsystems.rollers.commands;

import org.usfirst.frc3467.OI;
import org.usfirst.frc3467.commands.CommandBase;

public class SetRollerDirection extends CommandBase {
	double power = 0.0;
	
	public SetRollerDirection(double direction) {
		this.power = direction;
		requires(rollies);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		rollies.rollerFront.set(power);
		rollies.rollerBack.set(-power);
	}
	
	protected boolean isFinished() {
		if (power > 0) {
			return !OI.opGamepadAuto.getXButton();
		} else {
			return !OI.opGamepadAuto.getBButton();
		}
	}
	
	protected void end() {
		rollies.rollerFront.set(0);
		rollies.rollerBack.set(0);
	}
	
	protected void interrupted() {
		
	}
	
}
