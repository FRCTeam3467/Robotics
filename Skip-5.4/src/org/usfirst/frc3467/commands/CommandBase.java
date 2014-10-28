package org.usfirst.frc3467.commands;

import java.util.Vector;

import org.usfirst.frc3467.CommandBasedRobot;
import org.usfirst.frc3467.OI;
import org.usfirst.frc3467.other.ultrasonics.MaxbotixI2C;
import org.usfirst.frc3467.subsystems.DriveBase3V3.DriveBase;
import org.usfirst.frc3467.subsystems.leds.Leds;
import org.usfirst.frc3467.subsystems.rollers.Roller;
import org.usfirst.frc3467.subsystems.rollers.Rollies;
import org.usfirst.frc3467.subsystems.shooter.Mast;
import org.usfirst.frc3467.subsystems.shooter.Shooter;
import org.usfirst.frc3467.subsystems.shooter.Winch;
import org.usfirst.frc3467.subsystems.shooter.commands.auto.MyKinect;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	public static OI oi;
	public static CommandBase cb;
	public static DriveBase db;
	public static Shooter shooter;
	public static Mast mast;
	public static Winch winch;
	public static Roller roller;
	public static Rollies rollies;
	public static MyKinect kinect;
	public static MaxbotixI2C ultrasonics;
	public static Leds leds;
	// 90
	public static Vector subsystemList;
	
	public static void init() {
		subsystemList = new Vector();
		// Add new subsystems to the list
		
		db = new DriveBase();
		subsystemList.addElement(db);
		
		shooter = new Shooter();
		subsystemList.addElement(shooter);
		
		mast = new Mast(0, 0, 0);
		subsystemList.addElement(mast);
		
		roller = new Roller();
		subsystemList.addElement(roller);
		
		rollies = new Rollies();
		subsystemList.addElement(rollies);
		
		// Didn't add to PIDList
		winch = new Winch();
		subsystemList.addElement(winch);
		
		kinect = new MyKinect();
		subsystemList.addElement(kinect);
		
		ultrasonics = new MaxbotixI2C(0);
		subsystemList.addElement(ultrasonics);
		
		leds = new Leds();
		subsystemList.addElement(leds);
		
		oi = new OI();
		
		oi.BindCommands(OI.JAKE);
		oi.BindCommands(OI.ERIC);
		
		potInit();
	}
	
	public CommandBase() {
		super();
		cb = this;
	}
	
	public CommandBase(String name) {
		super(name);
	}
	
	public static void potInit() {
		System.out.println("Setting Pot Offsets");
		System.out.println("90 - file" + (90 - Double.parseDouble(CommandBasedRobot.mast.readFile())));
		System.out.println("Current Offset" + CommandBase.shooter.pot.getOffset());
		shooter.pot.setOffset(90 - Double.parseDouble(CommandBasedRobot.mast.readFile()));
		winch.pot.setOffset(-Double.parseDouble(CommandBasedRobot.winch.readFile()));
		roller.frontPot.setOffset(90 - Double.parseDouble(CommandBasedRobot.fr.readFile()));
		roller.backPot.setOffset(90 - Double.parseDouble(CommandBasedRobot.br.readFile()));
		System.out.println("New Offset" + CommandBase.shooter.pot.getOffset());
	}
}
