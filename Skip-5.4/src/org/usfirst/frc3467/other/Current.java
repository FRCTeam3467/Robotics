package org.usfirst.frc3467.other;

import edu.wpi.first.wpilibj.AnalogChannel;

public class Current extends AnalogChannel {
	
	private double BASE_VOLTAGE = 2.5;
	private double SCALE = 1.5 / 100; // 1.5V per 100 amps
	
	public Current(int channel) {
		super(channel);
	}
	
	public double getCurrent() {
		double inputVoltage = Math.abs(this.getAverageVoltage());
		return (inputVoltage - BASE_VOLTAGE) / SCALE;
	}
	
	public void setBaseVoltage(double baseVoltage) {
		BASE_VOLTAGE = baseVoltage;
	}
	
	public void setScale(double scale) {
		SCALE = scale;
	}
	
}
