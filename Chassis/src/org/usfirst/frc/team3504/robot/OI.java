package org.usfirst.frc.team3504.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {

	public enum DriveDirection {kFWD, kREV}; 

	private Joystick drivingStickForward = new Joystick(0);
	private Joystick drivingStickBackward = new Joystick(1);
	
	Joystick joystickName = new Joystick(RobotMap.JOYSTICK_PORT);
	
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

