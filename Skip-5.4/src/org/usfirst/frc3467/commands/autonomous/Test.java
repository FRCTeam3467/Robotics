package org.usfirst.frc3467.commands.autonomous;

import org.usfirst.frc3467.subsystems.DriveBase3V3.commands.DriveStraight;
import org.usfirst.frc3467.subsystems.DriveBase3V3.commands.ResetDBSensors;
import org.usfirst.frc3467.subsystems.DriveBase3V3.commands.ShiftUp;
import org.usfirst.frc3467.subsystems.shooter.commands.NewSoftShot;
import org.usfirst.frc3467.subsystems.shooter.commands.SetSetpoint;
import org.usfirst.frc3467.subsystems.shooter.commands.auto.WaitForSignal;
import org.usfirst.frc3467.subsystems.shooter.commands.winch.WinchIn;
import org.usfirst.frc3467.subsystems.shooter.commands.winch.groups.EndWinch;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class Test extends CommandGroup {
	public Test() {
		// Pick an autonomous routine to run
		// Pick an autonomous routine to run
		this.addParallel(new ShiftUp());
		this.addParallel(new ResetDBSensors());
		this.addSequential(new WaitCommand(0.2));
		this.addSequential(new SetSetpoint(100, false));
		this.addParallel(new DriveStraight(156, 0.80, false));
		this.addSequential(new WinchIn());
		this.addSequential(new EndWinch());
		this.addSequential(new SetSetpoint(119, false));
		this.addSequential(new WaitForChildren());
		this.addSequential(new WaitForSignal(), 4.0);
		this.addSequential(new NewSoftShot(1.0));
		this.addSequential(new SetSetpoint(90, false));
		
	}
}
