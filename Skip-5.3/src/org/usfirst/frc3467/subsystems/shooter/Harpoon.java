package org.usfirst.frc3467.subsystems.shooter;

import org.usfirst.frc3467.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Harpoon extends Subsystem {
	public static Solenoid sole1; //creates solenoid 1
	public static Solenoid sole2; //creates solenoid 2

	public Harpoon() {
		sole1 = new Solenoid(RobotMap.solenoidLoadIn); //defines load in from robotmap, makes the harpoon shoot out
		sole2 = new Solenoid(RobotMap.solenoidLoadOut); //defines load out from robotmap, makes the harpoon shoot back in
	}

	public void loadIn() {
		sole1.set(false); //sets solenoid 1 to false
		sole2.set(true); //sets solenoid 2 to true
	}

	public void loadOut() {
		sole1.set(true); //set solenoid 1 to true
		sole2.set(false); //set solenoid 2 to false
	}

	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
