package org.usfirst.frc3467.commands.shooter.loader;


import org.usfirst.frc3467.commands.CommandBase;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutoLoaderGroup extends CommandGroup {
	public AutoLoaderGroup() {
		// NEEDS TO BE REWRITTEN!!!
		requires(CommandBase.harpoon);
		double delay = 1.5;
		double lastDelay = 1.5;
		delay = delay / 2;
		lastDelay = lastDelay / 2;
		double between = 0.3;
		this.addSequential(new LoadOut());
		this.addSequential(new WaitCommand(delay));

		this.addSequential(new LoadIn()); // Push Frisbee out
		this.addSequential(new WaitCommand(between));
		this.addSequential(new LoadOut());
		this.addSequential(new WaitCommand(delay));

		this.addSequential(new LoadIn()); // Push Frisbee out
		this.addSequential(new WaitCommand(between));
		this.addSequential(new LoadOut());
		this.addSequential(new WaitCommand(lastDelay));

		this.addSequential(new LoadIn()); // Push Frisbee out
		this.addSequential(new WaitCommand(between));
		this.addSequential(new LoadOut());
		this.addSequential(new WaitCommand(lastDelay));

		this.addSequential(new LoadIn()); // Push Frisbee out
		this.addSequential(new WaitCommand(between));
		this.addSequential(new LoadOut());

	}
}
