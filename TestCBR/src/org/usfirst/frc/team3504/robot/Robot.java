
package org.usfirst.frc.team3504.robot;

import org.usfirst.frc.team3504.robot.subsystems.*;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static Chassis chassis;
	public static Camera camera;

	
    Command autonomousCommand;
    SendableChooser chooser;

    public void robotInit() {	
    	System.out.println("robot init");
		oi = new OI();
		chassis = new Chassis();
    	camera = new Camera();
		
     chooser = new SendableChooser();
     SmartDashboard.putData("Chooser", chooser);
    }
	
    public void disabledInit(){
    	System.out.println("disabled");
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	System.out.println("auto init");

    	if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	System.out.println("teleop init");
    	
    	if (autonomousCommand != null) autonomousCommand.cancel();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic() {
        //LiveWindow.run();
    }
}