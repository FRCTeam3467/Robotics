package org.usfirst.frc3467.commands.arm;

import org.usfirst.frc3467.commands.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoClimb extends CommandGroup {
	public AutoClimb() {
		this.addSequential(new CancelClimb(false));
		this.addSequential(new PullUp());
		this.addSequential(new Wait(0.75));
		this.addSequential(new MagicButtonEight());
		this.addSequential(new Wait(0.75));
		this.addSequential(new MagicButtonEight());
		this.addSequential(new Wait(0.75));
		this.addSequential(new GoToRung(600, true));
		this.addSequential(new CancelClimb(false));
	}
}
