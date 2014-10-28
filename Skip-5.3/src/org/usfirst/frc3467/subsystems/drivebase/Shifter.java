package org.usfirst.frc3467.subsystems.drivebase;

import org.usfirst.frc3467.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shifter extends Subsystem {
	Solenoid sole1; //defines solenoid #1
	Solenoid sole2; //defines solenoid #2
	public boolean isUp = false; //creates the isUp variable, sets it to false to reference when the shooter is up

	public Shifter() {
		sole1 = new Solenoid(RobotMap.shifterShiftUp); //defines shift up from robotmap
		sole2 = new Solenoid(RobotMap.shifterShiftDown);// defines shift down from robotmap
	}

	public void shifterShiftUp() {
		sole1.set(true); //sets solenoid 1 to true
		sole2.set(false); //sets solenoid 2 to false
		isUp = true; //changes the the isUp variable totrue, to indicate the shooter is up
	}

	public void ShifterShiftDown() {
		sole1.set(false); //sets solenoid 1 to false 
		sole2.set(true); //sets solenoid 2 to true
		isUp = false; //changes the isUp variable to false, to indicate the shooter is down
	}

	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
