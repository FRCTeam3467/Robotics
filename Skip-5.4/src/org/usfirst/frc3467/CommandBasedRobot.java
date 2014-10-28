/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc3467;

import java.util.Vector;

import org.usfirst.frc3467.commands.CheesyVisionServer;
import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.commands.autonomous.Auto2Foot;
import org.usfirst.frc3467.commands.autonomous.Auto2Foot2;
import org.usfirst.frc3467.commands.autonomous.Auto2Front;
import org.usfirst.frc3467.commands.autonomous.Auto2Sec;
import org.usfirst.frc3467.commands.autonomous.Auto2SecFoot;
import org.usfirst.frc3467.commands.autonomous.Auto2SecFootHalf;
import org.usfirst.frc3467.commands.autonomous.AutoNon;
import org.usfirst.frc3467.commands.autonomous.Test;
import org.usfirst.frc3467.commands.autonomous.Unh;
import org.usfirst.frc3467.commands.autonomous.UnhFast;
import org.usfirst.frc3467.other.FTC;
import org.usfirst.frc3467.other.PotCalibration;
import org.usfirst.frc3467.subsystems.leds.Leds;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to each mode, as described in the IterativeRobot documentation. If you change the name of this class or the package after creating this project, you must also update the manifest file in the resource directory.
 */
public class CommandBasedRobot extends IterativeRobot {
	Compressor compressor;
	Command autonomousCommand;
	SendableChooser autoChooser;
	public static Vector PIDList;
	public static FTC mast;
	public static FTC winch;
	public static FTC fr;
	public static FTC br;
	public static int Alliance = 0;
	
	public static CheesyVisionServer server = CheesyVisionServer.getInstance();
	public final int listenPort = 1180;
	
	public CommandBasedRobot() {
		PIDList = new Vector();
		mast = new FTC("file:///mastPot.txt");
		winch = new FTC("file:///winchPot.txt");
		fr = new FTC("file:///frPot.txt");
		br = new FTC("file:///brPot.txt");
	}
	
	public void robotInit() {
		// Initialize all subsystems
		CommandBase.init();
		// Start compressor
		compressor = new Compressor(RobotMap.compressorPressureSwitch, RobotMap.comperessorSpike);
		compressor.start();
		
		server.setPort(listenPort);
		server.start();
		
		// Add autonomous selector
		autoChooser = new SendableChooser();
		autoChooser.addDefault("UNH", new Unh());
		autoChooser.addObject("UNH Faster", new UnhFast());
		autoChooser.addObject("2 Ball Reg", new Auto2Front());
		autoChooser.addObject("2 Ball Sec", new Auto2Sec());
		autoChooser.addObject("2 Ball Foot", new Auto2Foot());
		autoChooser.addObject("2 Ball 2 Feet", new Auto2Foot2());
		autoChooser.addObject("2 Ball Sec + Foot", new Auto2SecFoot());
		autoChooser.addObject("2 Ball Sec + Foot 1/2", new Auto2SecFootHalf());
		autoChooser.addObject("0", new AutoNon());
		autoChooser.addObject("Test", new Test());
		
		SmartDashboard.putData("Auto", autoChooser);
		
		SmartDashboard.putData(new PotCalibration());
		
		Alliance = DriverStation.getInstance().getAlliance().value;
		
	}
	
	public void autonomousInit() {
		server.reset();
		server.startSamplingCounts();
		
		// schedule the autonomous command (example)
		for (int i = 0; i < PIDList.size(); i++) {
			PIDController controller = (PIDController) PIDList.elementAt(i);
			controller.reset();
			controller.enable();
		}
		
		autonomousCommand = (Command) autoChooser.getSelected();
		autonomousCommand.start();
	}
	
	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void teleopInit() {
		// if (autonomousCommand != null)
		// autonomousCommand.cancel();
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		
		// Resets all integral terms in pid controllers
		for (int i = 0; i < PIDList.size(); i++) {
			PIDController controller = (PIDController) PIDList.elementAt(i);
			controller.reset();
			controller.enable();
		}
		if (CommandBase.leds != null) {
			CommandBase.leds.setState("Teleop init", Leds.REG3, 0);
		}
	}
	
	public void disabledInit() {
		server.stopSamplingCounts();
		if (CommandBase.leds != null) {
			CommandBase.leds.setState("Teleop init", Leds.REG3, 1);
		}
	}
	
	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	
	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
	
}
