package org.usfirst.frc3467.subsystems.shooter;

import org.usfirst.frc3467.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
	double batteryBase = 12.00; // defines the battery voltage
	Jaguar jag; // defines the jaguar
	Relay lights; // defines the lights
	public double lastSpeed = 0; // defines the last speed the shooter was set at
	public double speedCopy = 0;// a copy of the current speed
	public static long time = 10000000; // time since the speed was set to 0 or changed from zero
	
	public Shooter() {
		jag = new Jaguar(RobotMap.shooterMotors); // defines the jaguar shooter motors
		lights = new Relay(RobotMap.lightsRelay, Relay.Direction.kForward); // defines the lights and which way the pattern is moving
	}
	
	public void setSpeed(double speed) {
		
		speed = ((batteryBase / DriverStation.getInstance().getBatteryVoltage()) * speed); // determines the speed the motors are to be set at based on batter voltage
		if (speed > 1.00)
			speed = 1.00; // rounds the speed down to 100% if it goes over
		if (speed != lastSpeed) {
			lastSpeed = speed; // sets the value of the last speed to the value of the speed
		}
		jag.set(speed); // sets the motor speed
		speedCopy = speed;// changes the speed copy value to the value of speed
		if (speedCopy == 0)
			time = System.currentTimeMillis(); // records he time speed was last set to 0
		if (lastSpeed == 0 && speedCopy != 0) {
			time = System.currentTimeMillis(); // records the time that the speed was changed from 0
		}
		
		if (speed > 0.0) {
			lights.set(Relay.Value.kOn); // if the shooter on, sets the ligths on
		} else {
			lights.set(Relay.Value.kOff); // if the shooter is off, sets the lights of
		}
	}
	
	public double getSpeed() {
		return speedCopy; // returns a copy of the current speed
	}
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}