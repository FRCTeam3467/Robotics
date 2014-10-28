package org.usfirst.frc3467.commands.shooter.loader;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.commands.shooter.CheckShooterSpeed;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class LoaderPop extends CommandGroup {
	public static boolean cancel = false;
	
	public LoaderPop() {
		requires(CommandBase.harpoon);  		// Requires the harpoon subsystem
		addSequential(new CheckShooterSpeed()); // Make sure shooter is up to speed
		addSequential(new LoadIn()); 			// Push the frisbee into the shooter wheel (AKA fire frisbee)
		addSequential(new WaitCommand(0.1));	// Wait 100ms for harpoon to push frisbee
		addSequential(new LoadOut());			// Retract the harpoon for next frisbee
		addSequential(new WaitCommand(0.1));	// Wait 100ms for harpoon to retract
	}
}
