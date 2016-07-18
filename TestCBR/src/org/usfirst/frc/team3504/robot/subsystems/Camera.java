package org.usfirst.frc.team3504.robot.subsystems;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.usfirst.frc.team3504.robot.Robot;
import org.usfirst.frc.team3504.robot.commands.UpdateCam;

import java.util.logging.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Camera extends Subsystem {
    
	//private CameraServer server;
	private NetworkTable table;
//	private Image frame;
//	private int cam;
	public final static Logger log = Logger.getLogger(Camera.class.getName());

	
	private static final int INVALID_CAMERA = -1;
	
	public Camera() throws InterruptedException {
		log.setLevel(Level.ALL);
		log.info("Camera init");
		
		Thread.sleep(1000);
		
		VideoCapture cam = new VideoCapture(0);
		
		log.info("Attempting to open camera");
		while(!cam.isOpened()) {
			cam.open(0);
		}
		
		log.info("Camera opened");
		
//	/	cam.set(CV_CAP_PROP_EXPOSURE_ABSOLUTE, 0.1);
		
		Mat frame = new Mat();
		
		cam.read(frame);
		log.info("Read frame");
		
		Highgui.imwrite("//home//lvuser//Vision//camera.jpg", frame);
		log.info("Done");
		
		/*
		table = NetworkTable.getTable("GRIP");
		for(String key : table.getKeys()) 
			System.out.println(key);
			*/
	}
	
	/* Grab a new image from the current camera, putting it into the frame.
	 * Then set that as the current frame in the camera server.
	 * If we don't have a working camera, just skip the whole process.
	 
	public void getImage() {
		if (cam != INVALID_CAMERA) {
			NIVision.IMAQdxGrab(cam, frame, 1);
			server.setImage(frame);
		}
	}
	*/
	@SuppressWarnings("deprecation")
	public void readNetworkTable() {
		/*
		double[] defaultValue = new double[0];
		double [] xs = table.getNumberArray("x", defaultValue);
		System.out.print("x: ");
		for(double x : xs) {
			System.out.print(x + " ");
		}
		*/

		double frame_rate = table.getNumber("myNumber", 0);
	
		if(frame_rate != 0.0) {
			System.out.println(frame_rate);
		}
		//System.out.println();
	}
	
    public void initDefaultCommand() {
     //   setDefaultCommand(new UpdateCam());
    }
}