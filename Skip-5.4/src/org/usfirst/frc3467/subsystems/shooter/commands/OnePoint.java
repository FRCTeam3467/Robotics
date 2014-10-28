package org.usfirst.frc3467.subsystems.shooter.commands;

import org.usfirst.frc3467.commands.CommandBase;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class OnePoint extends CommandGroup {
	public boolean done = false;
	
	public OnePoint(double power) {
		requires(CommandBase.winch);
		this.addParallel(new Fire(power, false));
		this.addSequential(new WaitForWinch(0.33));
		this.addSequential(new SetSetpoint(110, false));
	}
}
