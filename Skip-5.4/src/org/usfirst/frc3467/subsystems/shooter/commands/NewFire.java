package org.usfirst.frc3467.subsystems.shooter.commands;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.subsystems.shooter.commands.winch.DisengageMotor;
import org.usfirst.frc3467.subsystems.shooter.commands.winch.SetMotor;
import org.usfirst.frc3467.subsystems.shooter.commands.winch.UnlockBrake;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class NewFire extends CommandGroup {
	public boolean done = false;
	
	public NewFire() {
		requires(CommandBase.winch);
		this.addSequential(new DisengageMotor());
		this.addSequential(new SetMotor(0.0));
		this.addSequential(new UnlockBrake());
	}
}
