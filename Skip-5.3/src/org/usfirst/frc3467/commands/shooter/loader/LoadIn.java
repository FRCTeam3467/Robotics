package org.usfirst.frc3467.commands.shooter.loader;

import org.usfirst.frc3467.commands.CommandBase;

public class LoadIn extends CommandBase {
	public LoadIn() {
		requires(harpoon); 				// Requires harpoon subsystem
		setTimeout(0.1);				// End command after 100ms
	}

	protected void initialize() {

	}

	protected void execute() {
		if (LoaderPop.cancel == false)	// If the firing sequence is not not canceled
			harpoon.loadIn();			// Fire frisbee
	}

	protected void interrupted() {

	}

	protected boolean isFinished() {
		if (LoaderPop.cancel)			// If firing sequence is canceled, end command
			return true;
		else
			return isTimedOut();		// Or if it is timed out, end the command
	}

	protected void end() {

	}
}
