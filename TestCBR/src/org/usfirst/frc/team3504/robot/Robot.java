package org.usfirst.frc.team3504.robot;


import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.*;

import org.usfirst.frc.team3504.robot.subsystems.*;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static Chassis chassis;
	public static Camera camera;
	public final static Logger log = Logger.getLogger(Robot.class.getName());
		
    Command autonomousCommand;
    SendableChooser chooser;
     
    public void robotInit() {	
    	log.setLevel(Level.ALL);
    	log.info("robotInit");
    	
    	oi = new OI();
		//chassis = new Chassis();
		
//		System.out.println("Paths");
//		String property = System.getProperty("java.library.path");
//		StringTokenizer parser = new StringTokenizer(property, ";");
//		while(parser.hasMoreTokens()) {
//			System.out.println(parser.nextToken());
//		}
//		System.out.println("end paths");

		
		//System.load("/usr/local/lib/lib_OpenCV/java/libopencv_java2410.so");
		//System.load("/usr/local/lib/lib_OpenCV/java/opencv-2410.jar");
//		System.load("/usr/local/frc/rpath-lib/opencv-2413.jar");
		//System.loadLibrary("opencv_java2413");
		try {
			camera = new Camera();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
    	
		
    	chooser = new SendableChooser();
    	SmartDashboard.putData("Chooser", chooser);
    	
//    	try {
//    		new ProcessBuilder("/home/lvuser/grip").inheritIO().start();
//    	} catch(IOException e) {
//    		e.printStackTrace();
//    	}
    	
    	/*
		USBCamera cam = new USBCamera("cam0");
		cam.openCamera();
		cam.startCapture();
		*/
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