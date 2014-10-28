package org.usfirst.frc3467;

import org.usfirst.frc3467.control.Gamepad;
import org.usfirst.frc3467.other.Reverse;
import org.usfirst.frc3467.subsystems.DriveBase3V3.commands.ShiftDown;
import org.usfirst.frc3467.subsystems.DriveBase3V3.commands.ShiftUp;
import org.usfirst.frc3467.subsystems.rollers.commands.SetRollerDirection;
import org.usfirst.frc3467.subsystems.shooter.commands.FireGroup;
import org.usfirst.frc3467.subsystems.shooter.commands.NewSoftShot;
import org.usfirst.frc3467.subsystems.shooter.commands.OnePoint;
import org.usfirst.frc3467.subsystems.shooter.commands.OnePointChin;
import org.usfirst.frc3467.subsystems.shooter.commands.ReturnAll;
import org.usfirst.frc3467.subsystems.shooter.commands.SetSetpoint;
import org.usfirst.frc3467.subsystems.shooter.commands.ToggleSway;
import org.usfirst.frc3467.subsystems.shooter.commands.winch.LockBrake;
import org.usfirst.frc3467.subsystems.shooter.commands.winch.UnlockBrake;
import org.usfirst.frc3467.subsystems.shooter.commands.winch.WinchInGroup;
import org.usfirst.frc3467.subsystems.shooter.commands.winch.groups.SafeRelease;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	
	public static Joystick leftJoystick;
	public static Joystick rightJoystick;
	public static Gamepad opGamepadAuto;
	public static Joystick opGamepadManu;
	
	public static final int JAKE = 1;
	public static final int JAMES = 2;
	public static final int ERIC = 3;
	
	// DriveBase
	Button driveStraight;
	Button driveTurn;
	Button resetDBSensors;
	Button shiftDown;
	Button shiftUp;
	Button reverse;
	
	// Roller
	Button setSetpointRoller;
	Button resetPot;
	Button setRollerSpeed1;
	Button setRollerSpeed2;
	Button setRollerSpeed3;
	Button setFront90;
	Button setBack90;
	
	// Shooter
	Button returnAll;
	Button toggleSway;
	Button fire;
	Button softShot;
	Button safteyShot;
	Button safetyShotSlow;
	Button safteyShotOp;
	Button winchIn;
	Button winchInOp;
	Button presetOne;
	Button presetTwo;
	Button presetThree;
	Button presetFour;
	Button presetFive;
	Button presetSix;
	Button lockBrake;
	Button unlockBrake;
	Button autoAngle;
	
	public OI() {
		leftJoystick = new Joystick(1);
		rightJoystick = new Joystick(2);
		opGamepadAuto = new Gamepad(3);
		opGamepadManu = new Joystick(4);
	}
	
	public void BindCommands(int user) {
		System.out.print("Loading OI profile [" + user + ", ");
		switch (user) {
			case JAMES:
				System.out.println("James]");
				// Shooter
				
				// Rollers
				setRollerSpeed1 = new JoystickButton(opGamepadAuto, Gamepad.xButton);
				setRollerSpeed1.whenPressed(new SetRollerDirection(1.0));
				setRollerSpeed2 = new JoystickButton(opGamepadAuto, Gamepad.yButton);
				setRollerSpeed2.whenPressed(new SetRollerDirection(0.0));
				setRollerSpeed3 = new JoystickButton(opGamepadAuto, Gamepad.bButton);
				setRollerSpeed3.whenPressed(new SetRollerDirection(-1.0));
				// Presets
				presetOne = new JoystickButton(OI.opGamepadAuto, Gamepad.leftTrigger);
				presetOne.whenPressed(new OnePointChin(0.2));
				presetTwo = new JoystickButton(OI.opGamepadAuto, Gamepad.leftBumper);
				presetTwo.whenPressed(new SetSetpoint(90, true));
				presetThree = new JoystickButton(opGamepadManu, 9);
				presetThree.whenPressed(new SetSetpoint(123, true));
				presetFour = new JoystickButton(opGamepadManu, 11);
				presetFour.whenPressed(new SetSetpoint(116, true));
				presetFive = new JoystickButton(opGamepadManu, 10);
				presetFive.whenPressed(new SetSetpoint(131, true));
				presetSix = new JoystickButton(opGamepadManu, 12);
				presetSix.whenPressed(new SetSetpoint(100, true));
				winchInOp = new JoystickButton(opGamepadAuto, Gamepad.backButton);
				winchInOp.whenPressed(new WinchInGroup());
				safteyShotOp = new JoystickButton(opGamepadAuto, Gamepad.startButton);
				safteyShotOp.whenPressed(new NewSoftShot(RobotMap.softShotSpeed));
				setFront90 = new JoystickButton(opGamepadAuto, Gamepad.rightStickPress);
				setFront90.whenPressed(new ToggleSway(true, true));
				setBack90 = new JoystickButton(opGamepadAuto, Gamepad.leftStickPress);
				setBack90.whenPressed(new ToggleSway(false, true));
				returnAll = new JoystickButton(opGamepadAuto, Gamepad.aButton);
				returnAll.whenPressed(new ReturnAll());
				break;
			case ERIC:
				System.out.println("Eric]");
				// Shooter
				
				// Rollers
				setRollerSpeed1 = new JoystickButton(opGamepadAuto, Gamepad.xButton);
				setRollerSpeed1.whenPressed(new SetRollerDirection(1.0));
				setRollerSpeed3 = new JoystickButton(opGamepadAuto, Gamepad.bButton);
				setRollerSpeed3.whenPressed(new SetRollerDirection(-1.0));
				// Presets
				presetOne = new JoystickButton(OI.opGamepadAuto, Gamepad.leftTrigger);
				presetOne.whenPressed(new OnePointChin(0.2));
				presetTwo = new JoystickButton(OI.opGamepadAuto, Gamepad.leftBumper);
				presetTwo.whenPressed(new SetSetpoint(90, true));
				presetThree = new JoystickButton(opGamepadManu, 9);
				presetThree.whenPressed(new SetSetpoint(123, true));
				presetFour = new JoystickButton(opGamepadManu, 11);
				presetFour.whenPressed(new SetSetpoint(116, true));
				presetFive = new JoystickButton(opGamepadManu, 10);
				presetFive.whenPressed(new SetSetpoint(131, true));
				presetSix = new JoystickButton(opGamepadManu, 12);
				presetSix.whenPressed(new SetSetpoint(100, true));
				winchInOp = new JoystickButton(opGamepadAuto, Gamepad.backButton);
				winchInOp.whenPressed(new WinchInGroup());
				safteyShotOp = new JoystickButton(opGamepadAuto, Gamepad.startButton);
				safteyShotOp.whenPressed(new NewSoftShot(RobotMap.softShotSpeed));
				setFront90 = new JoystickButton(opGamepadAuto, Gamepad.rightStickPress);
				setFront90.whenPressed(new ToggleSway(true, true));
				setBack90 = new JoystickButton(opGamepadAuto, Gamepad.leftStickPress);
				setBack90.whenPressed(new ToggleSway(false, true));
				returnAll = new JoystickButton(opGamepadAuto, Gamepad.aButton);
				returnAll.whenPressed(new ReturnAll());
				break;
			case JAKE:
				System.out.println("Jake]");
				fire = new JoystickButton(rightJoystick, 3);
				fire.whenPressed(new FireGroup(false));
				softShot = new JoystickButton(leftJoystick, 3);
				softShot.whenPressed(new NewSoftShot(1.0));
				safteyShot = new JoystickButton(leftJoystick, 11);
				safteyShot.whenPressed(new OnePoint(RobotMap.softShotSpeed));
				safetyShotSlow = new JoystickButton(leftJoystick, 9);
				safetyShotSlow.whenPressed(new SafeRelease());
				shiftDown = new JoystickButton(leftJoystick, 1);
				shiftDown.whenPressed(new ShiftDown());
				shiftUp = new JoystickButton(rightJoystick, 1);
				shiftUp.whenPressed(new ShiftUp());
				winchIn = new JoystickButton(leftJoystick, 8);
				winchIn.whenPressed(new WinchInGroup());
				lockBrake = new JoystickButton(rightJoystick, 7);
				lockBrake.whenPressed(new LockBrake());
				lockBrake = new JoystickButton(rightJoystick, 6);
				lockBrake.whenPressed(new UnlockBrake());
				reverse = new JoystickButton(rightJoystick, 11);
				reverse.whenPressed(new Reverse());
				break;
			default:
				System.out.println("<error>]");
				System.out.println("User [" + user + "] does not exist, loading default bindings");
		}
		
	}
}
