package org.usfirst.frc3467;

import org.usfirst.frc3467.commands.arm.AutoClimb;
import org.usfirst.frc3467.commands.arm.CancelClimb;
import org.usfirst.frc3467.commands.arm.DriveCalibrate;
import org.usfirst.frc3467.commands.arm.MagicButtonEight;
import org.usfirst.frc3467.commands.arm.PistonDown;
import org.usfirst.frc3467.commands.arm.PistonUp;
import org.usfirst.frc3467.commands.arm.PrepArm;
import org.usfirst.frc3467.commands.arm.PullUp;
import org.usfirst.frc3467.commands.drivebase.shifters.ShiftDown;
import org.usfirst.frc3467.commands.drivebase.shifters.ShiftUp;
import org.usfirst.frc3467.commands.shooter.SetShooterSpeed;
import org.usfirst.frc3467.commands.shooter.angler.AnglerToggle;
import org.usfirst.frc3467.commands.shooter.loader.LoaderGroup;
import org.usfirst.frc3467.commands.shooter.loader.LoaderPop;
import org.usfirst.frc3467.interfaces.Gamepad;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
	public static Joystick leftJoystick = new Joystick(1); 		// Left driver joystick
	public static Joystick rightJoystick = new Joystick(2); 	// Right driver joystick
	public static Gamepad gamepad = new Gamepad(3);				// Operator shooter joystick
	public static Joystick operatorJoystick = new Joystick(4);
	
	Button shiftDown = new JoystickButton(leftJoystick, 1);
	Button shiftUp = new JoystickButton(rightJoystick, 1);
	
	Button setShooterSpeedA = new JoystickButton(gamepad, Gamepad.aButton);
	Button setShooterSpeedB = new JoystickButton(gamepad, Gamepad.bButton);
	Button setShooterSpeedX = new JoystickButton(gamepad, Gamepad.xButton);
	Button setShooterSpeedY = new JoystickButton(gamepad, Gamepad.yButton);
	Button setShooterSpeedStart = new JoystickButton(gamepad, Gamepad.startButton);
	
	Button shooterAnglerToggle = new JoystickButton(gamepad, Gamepad.leftBumper);
	Button shooterLoaderPop = new JoystickButton(gamepad, Gamepad.rightBumper);
	Button shooterLoaderGroup = new JoystickButton(gamepad, Gamepad.rightTrigger);
	Button armPrepGamepad = new JoystickButton(gamepad, Gamepad.leftTrigger);
	
	Button climb = new JoystickButton(operatorJoystick, 1);
	Button pistonUp = new JoystickButton(operatorJoystick, 4);
	Button pistonDown = new JoystickButton(operatorJoystick, 3);
	Button pullUp = new JoystickButton(operatorJoystick, 2);
	Button magic8 = new JoystickButton(operatorJoystick, 8);
	Button armPrep = new JoystickButton(operatorJoystick, 12);
	Button autoClimb = new JoystickButton(operatorJoystick, 1);
	Button cancelClimb = new JoystickButton(operatorJoystick, 11);
	
	public OI() {
		shiftDown.whenPressed(new ShiftDown());
		shiftUp.whenPressed(new ShiftUp());
		
		setShooterSpeedA.whenPressed(new SetShooterSpeed(0.85));
		setShooterSpeedB.whenPressed(new SetShooterSpeed(0.87));
		setShooterSpeedX.whenPressed(new SetShooterSpeed(0.83));
		setShooterSpeedY.whenPressed(new SetShooterSpeed(1.00));
		setShooterSpeedStart.whenPressed(new SetShooterSpeed(0));
		shooterAnglerToggle.whenPressed(new AnglerToggle());
		shooterLoaderPop.whenPressed(new LoaderPop());
		shooterLoaderGroup.whenPressed(new LoaderGroup());
		
		pistonUp.whenPressed(new PistonUp());
		pistonDown.whenPressed(new PistonDown());
		pullUp.whenPressed(new PullUp());
		magic8.whenPressed(new MagicButtonEight());
		armPrep.whenPressed(new PrepArm());
		autoClimb.whenPressed(new AutoClimb());
		armPrepGamepad.whenPressed(new PrepArm());
		cancelClimb.whenPressed(new CancelClimb(true));
		
		SmartDashboard.putData("Calibrate Arm", new DriveCalibrate());
	}
}
