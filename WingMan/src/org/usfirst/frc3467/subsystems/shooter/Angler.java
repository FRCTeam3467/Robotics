package org.usfirst.frc3467.subsystems.shooter;

import org.usfirst.frc3467.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Angler extends Subsystem {
	Solenoid sole1; // defines solenoid 1
	Solenoid sole2; // defines solenoid 2
	public boolean isUp = false; // creates the isUp variable, set it to false to indicate that the shooter is not up
	
	public Angler() {
		sole1 = new Solenoid(RobotMap.anglerPistonUp); // defines piston up from robotmap
		sole2 = new Solenoid(RobotMap.anglerPistonDown); // defines piston down from robotmao
	}
	
	public void anglerPistonUp() {
		sole1.set(true); // sets solenoid 1 to false
		sole2.set(false); // sets solenoid 2 to true
		isUp = true; // sets isUp to true, to indicate that the shooter is up
	}
	
	public void anglerPistonDown() {
		sole1.set(false);// sets solenoid 1 to true
		sole2.set(true); // set solenoid 2 to false
		isUp = false; // sets isUp to false, to indicate that the chooter is down
	}
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
}
