package org.usfirst.frc3467.subsystems.shooter.commands;

import org.usfirst.frc3467.OI;
import org.usfirst.frc3467.commands.CommandBase;

public class WaitForCon extends CommandBase {
	
	boolean ready = false;
	boolean auto = false;
	
	public WaitForCon(int hi) {
		// this.auto = auto;
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		if (OI.opGamepadAuto.getLeftTrigger() && (OI.rightJoystick.getRawButton(3))) {
			ready = true;
		}
	}
	
	protected boolean isFinished() {
		return ready;
	}
	
	protected void end() {
		ready = false;
	}
	
	protected void interrupted() {
		
	}
	
}
