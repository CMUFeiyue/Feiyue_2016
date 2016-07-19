package org.usfirst.frc.team3504.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team3504.robot.commands.ClosePneumatic;
import org.usfirst.frc.team3504.robot.commands.OpenPneumatic;

public class OI {
	
	Joystick Joy = new Joystick(1); 
	Button button5 = new JoystickButton(Joy, 5); //Open Pneumatic 
	Button button6 = new JoystickButton(Joy, 6); //Close Pneumatic

	public OI () 
	{
		button5.whenPressed(new OpenPneumatic());
		button6.whenPressed(new ClosePneumatic());
	}
}

