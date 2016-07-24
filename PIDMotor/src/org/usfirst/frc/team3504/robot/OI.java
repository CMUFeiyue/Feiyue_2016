package org.usfirst.frc.team3504.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team3504.robot.commands.TunePID;

public class OI {
	
	Joystick joy = new Joystick(RobotMap.JOYSTICK_PORT); 
	Button button1 = new JoystickButton(joy, 1);
	
	public OI () 
	{
		button1.whenPressed(new TunePID()); 
	}
}

