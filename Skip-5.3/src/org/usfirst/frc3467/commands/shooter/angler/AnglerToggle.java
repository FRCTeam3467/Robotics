package org.usfirst.frc3467.commands.shooter.angler;

import org.usfirst.frc3467.commands.CommandBase;

public class AnglerToggle extends CommandBase {
	public AnglerToggle() {
		requires(angler);
		setTimeout (0.1);
	}

	protected void end() {
		// TODO Auto-generated method stub

	}

	protected void execute() {
		

	}

	protected void initialize() {
		// TODO Auto-generated method stub
		if (angler.isUp == true)
			angler.anglerPistonDown();
		else
			angler.anglerPistonUp();
	}

	protected void interrupted() {
		// TODO Auto-generated method stub

	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

}
