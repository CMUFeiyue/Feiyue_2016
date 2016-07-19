
package org.usfirst.frc.team3504.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team3504.robot.subsystems.DriveMotor;

public class Robot extends IterativeRobot {

	public static DriveMotor driveMotor; 
	public static OI oi;
	Command autonomous;
	
    
    public void robotInit() {
    	driveMotor = new DriveMotor();
		oi = new OI();
		
        // instantiate the command used for the autonomous period
        //autonomousCommand = new driveForward();

//		SmartDashboard.putData("Drive Forward", new driveForward());
//		SmartDashboard.putData("Drive Backward", new driveBackward());
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        if (autonomous != null) 
        	{
        	autonomous.start();
        	}
    }
    
    public void autonomousPeriodic() {
    	Scheduler.getInstance().run();
    }

    public void teleopInit() {
	   if (autonomous != null) 
    	   {
    	   autonomous.cancel();
    	   }
    }

    public void disabledInit(){

    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
}
