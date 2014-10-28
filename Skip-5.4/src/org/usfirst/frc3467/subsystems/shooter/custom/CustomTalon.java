package org.usfirst.frc3467.subsystems.shooter.custom;

import edu.wpi.first.wpilibj.Talon;

public class CustomTalon extends Talon {
	
	public CustomTalon(int channel) {
		super(channel);
	}
	
	public void set(double speed) {
		this.set(-speed);
	}
	
}
