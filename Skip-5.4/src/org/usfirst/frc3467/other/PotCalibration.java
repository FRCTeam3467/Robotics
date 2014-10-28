package org.usfirst.frc3467.other;

import org.usfirst.frc3467.CommandBasedRobot;
import org.usfirst.frc3467.commands.CommandBase;

import edu.wpi.first.wpilibj.PIDController;

public class PotCalibration extends CommandBase {
	int calibrationTime = 20;
	
	public PotCalibration() {
		this.setTimeout(calibrationTime);
		requires(shooter);
		requires(roller);
		requires(winch);
		this.setInterruptible(false);
	}
	
	protected void initialize() {
		System.out.println("Starting Pot Calibration");
		System.out.println("Disabling all PID loops");
		for (int i = 0; i < CommandBasedRobot.PIDList.size(); i++) {
			PIDController controller = (PIDController) CommandBasedRobot.PIDList.elementAt(i);
			controller.disable();
		}
		shooter.angleMotor.set(0.0);
		roller.frontMotor.set(0.0);
		roller.backMotor.set(0.0);
		System.out.println("Calibrating Pots in 10 seconds");
	}
	
	protected void execute() {
		System.out.println("Time to calibration = " + (calibrationTime - this.timeSinceInitialized()) + " seconds");
	}
	
	protected boolean isFinished() {
		return this.isTimedOut();
	}
	
	protected void end() {
		CommandBasedRobot.mast.appendToFile(Double.toString(shooter.pot.get()));
		CommandBasedRobot.winch.appendToFile(Double.toString(winch.pot.get()));
		CommandBasedRobot.fr.appendToFile(Double.toString(roller.frontPot.pidGet() - roller.frontPot.getOffsetCust()));
		CommandBasedRobot.br.appendToFile(Double.toString(roller.backPot.pidGet() - roller.backPot.getOffsetCust()));
		potInit();
		System.out.println("Calibrated. Renabling all PID loops");
		for (int i = 0; i < CommandBasedRobot.PIDList.size(); i++) {
			PIDController controller = (PIDController) CommandBasedRobot.PIDList.elementAt(i);
			controller.reset();
			controller.enable();
		}
	}
	
	protected void interrupted() {
		end();
	}
}
