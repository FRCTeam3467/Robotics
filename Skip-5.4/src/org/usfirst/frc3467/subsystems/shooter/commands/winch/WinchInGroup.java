package org.usfirst.frc3467.subsystems.shooter.commands.winch;

import org.usfirst.frc3467.subsystems.shooter.commands.winch.groups.EndWinch;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class WinchInGroup extends CommandGroup {
	public WinchInGroup() {
		this.addSequential(new WinchIn());
		this.addSequential(new EndWinch());
	}
}
