package org.usfirst.frc.team9999.robot;

import org.usfirst.frc.team9999.robot.subsystems.Arm;
import org.usfirst.frc.team9999.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import  org.usfirst.frc.team9999.robot.subsystems.Drivemotor;


public class Robot extends IterativeRobot {
	public static Drivemotor DRIVEMOTOR; 
	public static OI oi;
	public static Chassis chassis;
	
	public static Arm ARM;

    Command autonomousCommand;
    SendableChooser chooser;

    public void robotInit() {
    	DRIVEMOTOR = new Drivemotor();
    	chassis=new Chassis();
    	oi = new OI();
        chooser = new SendableChooser();
        ARM = new Arm();
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
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
