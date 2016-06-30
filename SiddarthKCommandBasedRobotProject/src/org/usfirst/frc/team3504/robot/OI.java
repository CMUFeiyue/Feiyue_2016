package org.usfirst.frc.team3504.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team3504.robot.commands.DriveForward;
import org.usfirst.frc.team3504.robot.commands.DriveBackward;


public class OI {
	Joystick joystickName = new Joystick(RobotMap.JOYSTICK_PORT);
	Button button1 = new JoystickButton(joystickName, 1); 
	Button button2 = new JoystickButton(joystickName, 2);
	
	public OI () {
		button1.whileHeld(new DriveForward()); 
		button2.whenPressed(new DriveBackward());
	}
}

