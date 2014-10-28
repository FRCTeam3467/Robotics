package org.usfirst.frc3467.commands.shooter.loader;

import org.usfirst.frc3467.commands.CommandBase;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LoaderGroup extends CommandGroup {
	public LoaderGroup() {
		requires(CommandBase.harpoon);

		this.addSequential(new LoaderPop()); // Instead of customized delays
		this.addSequential(new LoaderPop()); // Just add a bunch of loader pops!
		this.addSequential(new LoaderPop()); // Add delays between them using the WaitCommand()
	}
}