package org.usfirst.frc3467.subsystems.shooter.commands.winch;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.subsystems.shooter.Winch;

public class WinchIn extends CommandBase {
	
	public WinchIn() {
		requires(winch);
		this.setTimeout(3);
		this.setInterruptible(false);
	}
	
	protected void initialize() {
		if (winch.pot.pidGet() < Winch.difference) {
			
			winch.engageMotor();
			System.out.println("Unlocking Brake");
			winch.unlockBrake();
		}
	}
	
	protected void execute() {
		// if (roller.frontPot.pidGet() > 80)
		// this.cancel();
		if (winch.pot.pidGet() < Winch.difference)
			winch.motor.set(1.0);
		else
			winch.motor.set(0.0);
		// SmartDashboard.putNumber("POT!!!", Winch.getInstance().pot.pidGet());
	}
	
	protected boolean isFinished() {
		return this.isCanceled() || (winch.pot.pidGet() > Winch.difference);
	}
	
	protected void end() {
		System.out.println("Finished Winching");
	}
	
	protected void interrupted() {
		// end();
	}
	
}
