
package org.usfirst.frc.team9999.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team9999.robot.commands.DriveForward;
import org.usfirst.frc.team9999.robot.subsystems.Arm;
import org.usfirst.frc.team9999.robot.subsystems.AutoChassis;
import org.usfirst.frc.team9999.robot.subsystems.Camera;
import org.usfirst.frc.team9999.robot.subsystems.Chassis;
import org.usfirst.frc.team9999.robot.subsystems.Shooter;

public class Robot extends IterativeRobot {

	public static Chassis chassis;
	public static Camera camera;
	public static Arm arm;
	public static Shooter shooter;
	public static OI oi;
	public static AutoChassis autoL;
	public static AutoChassis autoR;

    Command autonomousCommand;
    SendableChooser chooser;

    public void robotInit() {
		chassis = new Chassis();
		arm = new Arm();
		shooter = new Shooter();
        chooser = new SendableChooser();
        oi = new OI();
//        autoL = new AutoChassis(0,0,0,0,RobotMap.MOTORL_PORT,RobotMap.SLAVEL_PORT);
//        autoR = new AutoChassis(0,0,0,0,RobotMap.MOTORR_PORT,RobotMap.SLAVER_PORT);
//        chooser.addObject("drive forward",new DriveForward());
        
        SmartDashboard.putData("Auto mode", chooser);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
}
