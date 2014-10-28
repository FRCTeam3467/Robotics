package org.usfirst.frc3467.subsystems.shooter.commands.winch;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.subsystems.shooter.commands.NewFire;
import org.usfirst.frc3467.subsystems.shooter.commands.NewSoftShot;

public class UnlockBrake extends CommandBase {
	
	public UnlockBrake() {
		requires(winch);
	}
	
	protected void initialize() {
		// System.out.println("Unlocking Break");
		winch.unlockBrake();
	}
	
	protected void execute() {
		
	}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {
		if (this.getGroup() != null) {
			try {
				NewSoftShot group = (NewSoftShot) getGroup();
				group.done = true;
			} catch (Exception e) {
				
			}
			try {
				NewFire group = (NewFire) getGroup();
				group.done = true;
			} catch (Exception e) {
				
			}
			
		}
	}
	
	protected void interrupted() {
		
	}
	
}
