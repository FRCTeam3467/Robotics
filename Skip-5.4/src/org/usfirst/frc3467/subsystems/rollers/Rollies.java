package org.usfirst.frc3467.subsystems.rollers;

import org.usfirst.frc3467.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Rollies extends Subsystem {
	
	public Talon rollerFront;
	public Talon rollerBack;
	
	public Rollies() {
		rollerFront = new Talon(RobotMap.rollerTalonFront);
		rollerBack = new Talon(RobotMap.rollerTalonBack);
	}
	
	protected void initDefaultCommand() {
		
	}
	
}
