package org.usfirst.frc.team9999.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team9999.robot.RobotMap;
import org.usfirst.frc.team9999.robot.OI.DriveDirection;
import org.usfirst.frc.team9999.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public enum DriveDirection {kFWD, kREV}; 

	private Joystick drivingStickForward = new Joystick(0);
	private Joystick drivingStickBackward = new Joystick(1);
	
	Joystick driveStick = new Joystick(RobotMap.JOYSTICK_PORT_A);
	
	Button button1 = new JoystickButton(driveStick, 1); 
	Button button2 = new JoystickButton(driveStick, 2);
	Button button3 = new JoystickButton(driveStick, 3);
	private DriveDirection driveDirection = DriveDirection.kFWD; 
	
	
	public double getDrivingJoystickY() {
		if (driveDirection == DriveDirection.kFWD){
			return drivingStickForward.getY();
		}
		else {
			return -drivingStickBackward.getY(); 
		}
	}

	public double getDrivingJoystickX() {
		if (driveDirection == DriveDirection.kFWD){
			return drivingStickForward.getX();
		}
		else {
			return drivingStickBackward.getX(); 
		}
	}
}

