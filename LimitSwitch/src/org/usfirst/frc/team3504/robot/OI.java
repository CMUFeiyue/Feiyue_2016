package org.usfirst.frc.team3504.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team3504.robot.commands.DriveUntilLimitSwitchIsPressed;

public class OI {
	
	Joystick Joy = new Joystick(RobotMap.JOYSTICK_PORT); 
	Button button3 = new JoystickButton(Joy, 3); //drive forward after button release until limit bumped 
//	Button button4 = new JoystickButton(Joy, 4); //after button, drive forward while limit held down
	
	public OI () 
	{
		button3.whenReleased(new DriveUntilLimitSwitchIsPressed());
	//	button4.whenReleased(new DriveWhileLimitSwitchIsPressed());
	}
}

