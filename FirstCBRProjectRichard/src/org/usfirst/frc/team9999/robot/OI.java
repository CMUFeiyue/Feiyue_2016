package org.usfirst.frc.team9999.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team9999.robot.commands.DriveForward;
import org.usfirst.frc.team9999.robot.commands.DriveUntilLimitSwitchIsPressed;
import org.usfirst.frc.team9999.robot.commands.SolenoidBackward;
import org.usfirst.frc.team9999.robot.commands.SolenoidForward;
import org.usfirst.frc.team9999.robot.commands.DriveBackward;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public enum DriveDirection {kFWD, kREV}; 
	Joystick joystickName = new Joystick(RobotMap.JOYSTICK_PORT);
	
	private Joystick drivingStickForward = new Joystick(0);
	private Joystick drivingStickBackward = new Joystick(1);
	
	Button button3 = new JoystickButton(joystickName,3);
	Button button2 = new JoystickButton(joystickName,2);
	
	Button button6 = new JoystickButton(joystickName, 6);
	Button button8 = new JoystickButton(joystickName, 8);
	
	Button button4 = new JoystickButton(joystickName, 4);
	
	private DriveDirection driveDirection=DriveDirection.kFWD;
	
	public OI(){
		button4.whileHeld(new DriveForward());
		button2.whenPressed(new DriveBackward());
		button3.whenPressed(new DriveUntilLimitSwitchIsPressed());
		
		button6.whenPressed(new SolenoidForward());
		button8.whenPressed(new SolenoidBackward());
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


