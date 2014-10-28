package org.usfirst.frc3467.commands.arm;

import org.usfirst.frc3467.RobotMap;
import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.commands.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MagicButtonEight extends CommandGroup {
	public MagicButtonEight() {
		requires(CommandBase.arm);
		this.addSequential(new GoToRung(RobotMap.maxEncCount, false));
		this.addSequential(new Wait(1.4));
		this.addSequential(new PullUp());
		// this.addSequential(new GoToRung(90, true));
	}
}
