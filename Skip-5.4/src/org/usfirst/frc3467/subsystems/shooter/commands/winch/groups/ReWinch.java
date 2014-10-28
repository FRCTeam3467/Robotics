package org.usfirst.frc3467.subsystems.shooter.commands.winch.groups;

import org.usfirst.frc3467.subsystems.shooter.commands.winch.PrepareRollers;
import org.usfirst.frc3467.subsystems.shooter.commands.winch.WinchIn;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class ReWinch extends CommandGroup {
	public ReWinch() {
		this.addSequential(new PrepareRollers());
		this.addSequential(new WaitCommand(0.1));
		this.addSequential(new WinchIn());
		
	}
}
