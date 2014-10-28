package org.usfirst.frc3467.subsystems.shooter.commands;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.other.Reverse;

public class ToggleSway extends CommandBase {
	private boolean front = false;
	private boolean state = false;
	
	public ToggleSway(boolean front, boolean state) {
		this.front = front;
		this.state = state;
	}
	
	protected void initialize() {
		if (!Reverse.reverse) {
			if (front) {
				shooter.frontSway = state;
			} else {
				shooter.backSway = state;
			}
		} else {
			if (!front)
				shooter.frontSway = state;
			else
				shooter.backSway = state;
		}
	}
	
	protected void execute() {
		
	}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {
		if (front) {
			System.out.println("Front sway: " + state);
		} else {
			System.out.println("Back sway: " + state);
		}
	}
	
	protected void interrupted() {
		
	}
	
}
