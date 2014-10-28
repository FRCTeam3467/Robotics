package org.usfirst.frc3467.subsystems.leds;

import edu.wpi.first.wpilibj.DigitalModule;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Leds extends Subsystem {
	
	private final int I2C_ADDRESS = 0x62;
	public static final int REG1 = 0x0;
	public static final int REG2 = 0x1;
	public static final int REG3 = 0x2;
	public static final int REG4 = 0x3;
	public static final int REG5 = 0x4;
	private static final int I2C_SLOT = DigitalModule.getDefaultDigitalModule();
	
	public static final int IDLE = 0;
	public static final int HIGH_CURRENT = 1;
	public static final int ONE_THIRTY = 2;
	public static final int TRUSS = 3;
	public static final int CLOSE = 4;
	public static final int TRUSS2 = 5;
	
	private final boolean DEBUGGING = true;
	
	public I2C leds;
	
	public Leds() {
		leds = new I2C(DigitalModule.getInstance(I2C_SLOT), I2C_ADDRESS);
	}
	
	protected void initDefaultCommand() {
		this.setDefaultCommand(new UpdateLeds());
		SmartDashboard.putData("Forward", new SetLeds(0));
		SmartDashboard.putData("Reverse", new SetLeds(1));
		SmartDashboard.putData("Idle", new SetLeds(2));
		SmartDashboard.putData("HC", new SetLeds(3));
		SmartDashboard.putData("130", new SetLeds(4));
		SmartDashboard.putData("Truss", new SetLeds(5));
		SmartDashboard.putData("Close", new SetLeds(6));
	}
	
	public void setState(String location, int state) {
		// if (DEBUGGING) {
		// System.out.println("Location: " + location + "	State: " + state);
		// }
		setState(location, REG2, state);
	}
	
	public void setState(String location, int reg, int state) {
		if (DEBUGGING) {
			System.out.println("Location: " + location + "	State: " + state);
		}
		if (leds.write(reg, state)) {
			System.out.println("Transaction failed");
		}
	}
}
