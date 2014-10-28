package org.usfirst.frc3467.subsystems.rollers.commands;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.other.Reverse;

public class SetRoller extends CommandBase {
	double power = 0.0;
	boolean front;
	
	public SetRoller(double direction, boolean front) {
		requires(rollies);
		this.power = direction;
		this.front = front;
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		if (!Reverse.reverse) {
			if (front) {
				rollies.rollerFront.set(power);
			} else {
				rollies.rollerBack.set(-power);
			}
		} else {
			if (front) {
				rollies.rollerBack.set(-power);
			} else {
				rollies.rollerFront.set(power);
			}
		}
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		if (front) {
			rollies.rollerFront.set(0.0);
		} else {
			rollies.rollerBack.set(0.0);
		}
	}
	
	protected void interrupted() {
		
	}
	
}
