package org.usfirst.frc3467.subsystems.shooter.commands.winch;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.subsystems.shooter.commands.winch.groups.EndWinch;

public class SetMotor extends CommandBase {
	double speed = 0.0;
	
	public SetMotor(double speed) {
		requires(winch);
		// requires(bogus);
		this.speed = speed;
		this.setTimeout(0.1);
	}
	
	protected void initialize() {
		System.out.println("Setting Motor to speed: " + speed);
	}
	
	protected void execute() {
		winch.motor.set(speed);
	}
	
	protected boolean isFinished() {
		return this.isTimedOut();
	}
	
	protected void end() {
		// TODO Auto-generated method stub
		if (this.getGroup() != null) {
			System.out.println("Canceling Group");
			EndWinch.ended = true;
		}
	}
	
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
}
