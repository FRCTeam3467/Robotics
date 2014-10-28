/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc3467;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.commands.autonomous.Auto;
import org.usfirst.frc3467.commands.shooter.SetShooterSpeed;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to each mode, as described in the IterativeRobot documentation. If you change the name of this class or the package after creating this project, you must also update the manifest file in the resource directory.
 */
public class CommandBasedRobot extends IterativeRobot {
	Compressor comp;
	Command autonomousCommand;
	
	/**
	 * This function is run when the robot is first started up and should be used for any initialization code.
	 */
	// Well well welll noah is dumb
	// What do we have here?
	public void robotInit() {
		// instantiate the command used for the autonomous period
		// autonomousCommand = new Auto();
		comp = new Compressor(RobotMap.pressureSwitch, RobotMap.compressor);
		comp.start();
		CommandBase.init();
	}
	
	public void autonomousInit() {
		// schedule the autonomous command (example)
		autonomousCommand = new Auto(0.83);
		autonomousCommand.start();
	}
	
	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		Scheduler.getInstance().add(new SetShooterSpeed(0));
	}
	
	public void disabledInit() {
		
	}
	
	public void disabledPeriodic() {
		
	}
	
	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
}
