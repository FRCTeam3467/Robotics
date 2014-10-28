package org.usfirst.frc3467.commands;

import org.usfirst.frc3467.commands.shooter.loader.LoaderPop;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CancelGroup extends CommandBase {
	CommandGroup groupCancel;
	public CancelGroup(CommandGroup group) {
		groupCancel = group;
	}
	protected void initialize() {
		if (LoaderPop.cancel) {		// If the sequence is canceled, cancel the group
			groupCancel.cancel();
		}
	}

	protected void execute() {

	}

	protected boolean isFinished() {
		return true;
	}

	protected void interrupted() {

	}
	
	protected void end() {

	}

}
