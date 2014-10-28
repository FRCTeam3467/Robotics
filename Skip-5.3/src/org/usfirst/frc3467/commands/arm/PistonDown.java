package org.usfirst.frc3467.commands.arm;

import org.usfirst.frc3467.commands.CommandBase;

public class PistonDown extends CommandBase {
	public PistonDown() {
		// requires(arm);
	}
	
	protected void initialize() {
		arm.retractPiston();
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
