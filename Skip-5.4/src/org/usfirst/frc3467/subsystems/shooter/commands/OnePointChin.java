package org.usfirst.frc3467.subsystems.shooter.commands;

import org.usfirst.frc3467.commands.CommandBase;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class OnePointChin extends CommandGroup {
	public boolean done = false;
	
	public OnePointChin(double power) {
		requires(CommandBase.winch);
		this.addSequential(new SetSetpoint(70, true));
		this.addSequential(new WaitForError(1.0));
		this.addParallel(new Fire(power, false));
		this.addSequential(new SetSetpoint(100, true));
		
		/*
		 * this.addSequential(new ToggleSway(true, false)); this.addSequential(new SetSetpoint(70, false)); this.addSequential(new WaitForError(3.0)); this.addParallel(new Fire(power, false)); this.addSequential(new SetSetpoint(115, false)); this.addSequential(new WaitForError(3.0)); this.addSequential(new SetSetpoint(90, true)); this.addSequential(new WaitForError(3.0)); this.addSequential(new WinchIn()); this.addSequential(new EndWinch()); this.addSequential(new ReturnAll());
		 */
	}
}
