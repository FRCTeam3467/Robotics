package org.usfirst.frc3467.subsystems.rollers.custom;

import edu.wpi.first.wpilibj.AnalogChannel;

public class CustomPot extends AnalogChannel {
	private double offset = 0;
	private double scale = 1.0;
	
	public CustomPot(int channel, double scale) {
		super(channel);
		this.scale = scale;
	}
	
	public double pidGet() {
		// System.out.println(offset + "         " + (this.get() + offset) / (22.0 / 12.0));
		// System.out.println(this.get());
		return ((this.getVoltage() * scale) + offset);
	}
	
	public void setOffset(double offset) {
		this.offset = offset;
	}
	
	public double getRawVoltage() {
		return this.getRawVoltage();
	}
	
	public double getOffsetCust() {
		return offset;
	}
	
}
