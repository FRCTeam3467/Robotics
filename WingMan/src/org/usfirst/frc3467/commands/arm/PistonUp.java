package org.usfirst.frc3467.commands.arm;

import org.usfirst.frc3467.commands.CommandBase;

public class PistonUp extends CommandBase {
	public PistonUp() {
		// requires(arm);
	}
	
	protected void initialize() {
		arm.extendPiston();
	}
	
	protected void execute() {
		// TODO Auto-generated method stub
		
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
	
	protected void end() {
		// TODO Auto-generated method stub
		
	}
	
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
}
