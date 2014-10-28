package org.usfirst.frc3467.commands;

import org.usfirst.frc3467.OI;
import org.usfirst.frc3467.subsystems.arm.Arm;
import org.usfirst.frc3467.subsystems.drivebase.DriveBase;
import org.usfirst.frc3467.subsystems.drivebase.Shifter;
import org.usfirst.frc3467.subsystems.shooter.Angler;
import org.usfirst.frc3467.subsystems.shooter.Harpoon;
import org.usfirst.frc3467.subsystems.shooter.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	public static OI oi;
	public static DriveBase driveBase;
	public static Shooter shooter;
	public static Harpoon harpoon;
	public static Angler angler;
	public static CommandBase cb;
	public static Shifter shifter;
	public static Arm arm;
	
	public static void init() {
		driveBase = new DriveBase(); 	// Create new drive base subsystem
		shooter = new Shooter(); 		// Create new shooter subsystem
		harpoon = new Harpoon();		// Create new harpoon subsystem
		angler = new Angler();			// Create new angler subsystem
		shifter = new Shifter();		// Create new shifter subsystem
		arm = new Arm();			// Create new arm subsystem
		oi = new OI();
		arm.initialize();
		
	}
	
	public CommandBase(String name) {
		super(name);
	}
	
	public CommandBase() {
		super();
		cb = this;
	}
	
}
