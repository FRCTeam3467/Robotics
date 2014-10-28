package org.usfirst.frc3467.subsystems.shooter.commands;

import org.usfirst.frc3467.CommandBasedRobot;
import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.subsystems.leds.Leds;

import edu.wpi.first.wpilibj.DriverStation.Alliance;

public class Fire extends CommandBase {
	boolean fullPower = true;
	double power = 0.0;
	
	public Fire(double power, boolean fullPower) {
		requires(winch);
		this.fullPower = fullPower;
		this.power = power;
	}
	
	protected void initialize() {
		if (CommandBasedRobot.Alliance == Alliance.kBlue_val) {
			if (fullPower) {
				leds.setState("Shot fired blue full", Leds.REG4, 0);
			} else {
				leds.setState("Shot fired blue soft", Leds.REG4, 2);
			}
		} else {
			if (fullPower) {
				leds.setState("Shot fired red full", Leds.REG4, 1);
			} else {
				leds.setState("Shot fired red soft", Leds.REG4, 3);
			}
		}
	}
	
	protected void execute() {
		if (fullPower) {
			System.out.println("FULL POWER SHOT");
			winch.disengageMotor();
		} else {
			System.out.println("SHOFT SHOT");
			winch.engageMotor();
		}
		winch.unlockBrake();
		winch.motor.set(-power);
	}
	
	protected boolean isFinished() {
		return (winch.pot.pidGet() < 60);
	}
	
	protected void end() {
		System.out.println("Ending Fire");
		winch.motor.set(0.0);
	}
	
	protected void interrupted() {
		
	}
	
}
