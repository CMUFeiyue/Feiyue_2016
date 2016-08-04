package org.usfirst.frc.team9999.robot;

import org.usfirst.frc.team9999.robot.commands.ToggleArm;
import org.usfirst.frc.team9999.robot.commands.Intake;
//import org.usfirst.frc.team9999.robot.Robot;
//import org.usfirst.frc.team9999.robot.commands.Move;
import org.usfirst.frc.team9999.robot.commands.Shoot;
import org.usfirst.frc.team9999.robot.commands.Stop;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
     Joystick stick = new Joystick(RobotMap.JOYSTICK_PORT);
     Joystick pad = new Joystick(RobotMap.PAD_PORT);
     
     
//     Button moveBut = new JoystickButton(stick,1);
     Button intake = new JoystickButton(pad,5);
     Button liftArm = new JoystickButton(pad,6);
     Button shoot = new JoystickButton(pad,7);
     Button changeCam = new JoystickButton(stick,2);
     Button stop = new JoystickButton(stick,1);
     
     public OI(){
    	 super();
//    	 moveBut.whenPressed(new Move());
    	 liftArm.whenPressed(new ToggleArm());
    	 shoot.whenPressed(new Shoot());
    	 intake.whenPressed(new Intake());
    	 stop.whenPressed(new Stop());
     }
     
     public boolean isStoped(){
    	 return false;
     }

     public double getX(){
    	 return -stick.getX();
     }
     
     public double getY(){
    	 return stick.getY();
     }

	public boolean changeCam() {
		return this.changeCam.get();
	}
}

