package org.usfirst.frc3467.commands.drivebase.shifters;

import org.usfirst.frc3467.commands.CommandBase;

public class ShiftUp extends CommandBase {
	public ShiftUp() {
		requires(shifter);			// Requires shifter subsystem
		setTimeout(0.1);			// Set timeout to 100ms
	}

	protected void initialize() {

	}

	protected void execute() {
		shifter.shifterShiftUp();	// Shift down

	}

	protected void interrupted() {

	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {

	}
}
