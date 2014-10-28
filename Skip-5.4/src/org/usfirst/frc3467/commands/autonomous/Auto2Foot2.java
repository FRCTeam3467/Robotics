package org.usfirst.frc3467.commands.autonomous;

import org.usfirst.frc3467.subsystems.DriveBase3V3.commands.DriveStraight;
import org.usfirst.frc3467.subsystems.DriveBase3V3.commands.ResetDBSensors;
import org.usfirst.frc3467.subsystems.DriveBase3V3.commands.ShiftUp;
import org.usfirst.frc3467.subsystems.rollers.commands.SetRoller;
import org.usfirst.frc3467.subsystems.shooter.commands.NewSoftShot;
import org.usfirst.frc3467.subsystems.shooter.commands.SetSetpoint;
import org.usfirst.frc3467.subsystems.shooter.commands.winch.WinchIn;
import org.usfirst.frc3467.subsystems.shooter.commands.winch.groups.EndWinch;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class Auto2Foot2 extends CommandGroup {
	public Auto2Foot2() {
		// Pick an autonomous routine to run
		this.addSequential(new WaitCommand(1.0));
		this.addParallel(new ShiftUp());
		this.addParallel(new ResetDBSensors());
		this.addSequential(new WaitCommand(0.2));
		this.addSequential(new SetSetpoint(100, false));
		this.addParallel(new DriveStraight(204, 0.75, false));
		this.addSequential(new WinchIn());
		this.addSequential(new EndWinch());
		this.addSequential(new SetSetpoint(119, false));
		this.addSequential(new WaitForChildren());
		
		// this.addSequential(new ToggleSway(true, false));
		// this.addSequential(new org.usfirst.frc3467.subsystems.rollers.commands.SetSetpoint(42, true));
		
		this.addSequential(new WaitCommand(0.3));
		
		this.addSequential(new NewSoftShot(1.0));
		
		this.addSequential(new SetSetpoint(130, false));
		this.addSequential(new WaitCommand(0.2));
		this.addSequential(new SetRoller(1.0, true), 1.6);
		this.addSequential(new SetSetpoint(119, false));
		this.addSequential(new WaitCommand(0.6));
		
		this.addSequential(new NewSoftShot(1.0));
		// Doesn't need to happen in 10 seconds
		// this.addParallel(new ToggleSway(true, true));
		this.addSequential(new SetSetpoint(90, false));
		this.addSequential(new SetRoller(0.0, true), 0.2);
	}
}
