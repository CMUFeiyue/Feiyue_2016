package org.usfirst.frc.team9999.robot;

import org.usfirst.frc.team9999.robot.commands.Drive_Forward;
import org.usfirst.frc.team9999.robot.commands.Drive_Backward;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;

public class OI{
	public enum DriveDirection {kFWD,kREV};
	Joystick joystickName = new Joystick(RobotMap.JOYSTICK_PORT);
	private DriveDirection driveDirection = DriveDirection.kFWD;
	
	Button button1 = new JoystickButton(joystickName,1);
	Button button2 = new JoystickButton(joystickName,2);
	
	private Joystick drivingStickForward = new Joystick(0);
	private Joystick drivingStickBackward = new Joystick(1);

	public OI(){
		button1.whileHeld(new Drive_Forward());
		button2.whenPressed(new Drive_Backward());
	}
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

