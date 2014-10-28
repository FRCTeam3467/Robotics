package org.usfirst.frc3467.commands.arm;

import org.usfirst.frc3467.commands.shooter.SetShooterSpeed;
import org.usfirst.frc3467.commands.shooter.angler.AnglerDown;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PrepArm extends CommandGroup {
	public PrepArm() {
		this.addParallel(new SetShooterSpeed(0.0));
		this.addSequential(new AnglerDown());
		this.addSequential(new GoToRung(800, true));
	}
}
