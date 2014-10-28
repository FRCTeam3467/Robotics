package org.usfirst.frc3467.subsystems.shooter.commands.winch.groups;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.subsystems.shooter.commands.winch.DisengageMotor;
import org.usfirst.frc3467.subsystems.shooter.commands.winch.LockBrake;
import org.usfirst.frc3467.subsystems.shooter.commands.winch.SetMotor;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class EndWinch extends CommandGroup {
	public static boolean ended = false;
	
	public EndWinch() {
		this.setInterruptible(true);
		requires(CommandBase.winch);
		this.addSequential(new LockBrake());
		this.addSequential(new WaitCommand(0.03));
		this.addSequential(new DisengageMotor());
		this.addSequential(new SetMotor(0.0));
	}
	
	public boolean isFinished() {
		System.out.println(ended);
		return ended;
	}
}
