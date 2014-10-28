package org.usfirst.frc3467.commands.autonomous;

import org.usfirst.frc3467.commands.shooter.SetShooterSpeed;
import org.usfirst.frc3467.commands.shooter.angler.AnglerDown;
import org.usfirst.frc3467.commands.shooter.loader.AutoLoaderGroup;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Auto extends CommandGroup {
	public Auto(double d) {
		// this.addSequential(new DriveCalibrate()); // No arm yet so no calibration
		this.addParallel(new SetShooterSpeed(d)); 	// Bring shooter to specified speed
		
		this.addSequential(new WaitCommand(2));   	// Give the shooter 2 seconds to get up to speed
		this.addSequential(new AutoLoaderGroup());	// Fire all the frisbees
		
		this.addParallel(new AnglerDown());			// Put down the angler
		this.addParallel(new SetShooterSpeed(0.0)); // Turn off the shooter
	}
}
