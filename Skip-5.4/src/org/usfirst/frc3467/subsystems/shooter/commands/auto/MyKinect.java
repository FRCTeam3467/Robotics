package org.usfirst.frc3467.subsystems.shooter.commands.auto;

import edu.wpi.first.wpilibj.KinectStick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class MyKinect extends Subsystem {
	KinectStick rightArm;
	double armAngle = 0.0;
	
	public MyKinect() {
		rightArm = new KinectStick(2);
	}
	
	protected void initDefaultCommand() {
		// this.setDefaultCommand(new UpdateArmAngle());
	}
	
	public double getY() {
		return this.rightArm.getY();
	}
}
