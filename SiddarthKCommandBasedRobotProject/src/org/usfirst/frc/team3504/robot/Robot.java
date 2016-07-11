
package org.usfirst.frc.team3504.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team3504.robot.subsystems.DriveMotor;


public class Robot extends IterativeRobot {


	public static OI oi;
    public static final DriveMotor DRIVEMOTOR = new DriveMotor();

    Command autonomousCommand;
    SendableChooser chooser;

    
    public void robotInit() {
		oi = new OI();
        chooser = new SendableChooser();

//        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);
    }
	
	
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
     
		
        if (autonomousCommand != null) autonomousCommand.start();
    }

   
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

  
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
   
    public void testPeriodic() {
        LiveWindow.run();
    }
}