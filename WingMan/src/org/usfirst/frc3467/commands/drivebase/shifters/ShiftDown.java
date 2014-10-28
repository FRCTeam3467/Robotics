package org.usfirst.frc3467.commands.drivebase.shifters;

import org.usfirst.frc3467.commands.CommandBase;

public class ShiftDown extends CommandBase {
	public ShiftDown() {
		requires(shifter);			// Requires shifter subsystem
		setTimeout(0.1);			// Set the timeout to 100ms
	}

	protected void initialize() {

	}

	protected void execute() {
		shifter.ShifterShiftDown(); // Shift down

	}

	protected void interrupted() {

	}

	protected void end() {

	}

	protected boolean isFinished() {
		return isTimedOut();
	}

}
