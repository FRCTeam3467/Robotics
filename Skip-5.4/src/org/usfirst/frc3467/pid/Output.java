package org.usfirst.frc3467.pid;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.parsing.IDeviceController;

public class Output implements SpeedController, PIDOutput, IDeviceController {
	
	private double output = -2000;
	private Talon motor = null;
	private boolean reverse = false;
	
	public Output(Talon motor, boolean reverse) {
		this.motor = motor;
		this.reverse = reverse;
	}
	
	public Output(boolean reverse) {
		this.reverse = reverse;
	}
	
	public Output() {
		
	}
	
	public void pidWrite(double output) {
		if (reverse)
			this.output = -output;
		else
			this.output = output;
		// System.out.println("Setting output to: " + output);
		if (motor != null)
			if (reverse)
				motor.set(-output);
			else
				motor.set(output);
	}
	
	public double getOutput() {
		return output;
	}
	
	public void set(double speed, byte syncGroup) {
		motor.set(speed, syncGroup);
		// Feed();
	}
	
	public void set(double speed) {
		motor.set(speed);
		// Feed();
	}
	
	public void disable() {
		
	}
	
	public double get() {
		return output;
	}
	
}
