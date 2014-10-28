package org.usfirst.frc3467.commands.shooter.angler;

import org.usfirst.frc3467.commands.CommandBase;

public class AnglerUp extends CommandBase {
	public AnglerUp() {
		requires(angler);
		setTimeout(0.1);
	}

	protected void end() {
		// TODO Auto-generated method stub

	}

	protected void execute() {
		angler.anglerPistonUp();

	}

	protected void initialize() {
		// TODO Auto-generated method stub

	}

	protected void interrupted() {
		// TODO Auto-generated method stub

	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}
}
