package org.usfirst.frc.team3504.robot.subsystems;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.usfirst.frc.team3504.robot.RobotMap;
import org.usfirst.frc.team3504.robot.commands.UpdateCam;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {
    
	private CameraServer server;
	private Image frame;
	private int cam;
	public final static Logger log = Logger.getLogger(Camera.class.getName());
	
	private static ArrayList<Integer> openCams = new ArrayList<Integer>();
	
	public Camera() {
		log.setLevel(Level.ALL);
		log.info("Camera init");
		
		for(String camName : RobotMap.CAMERA_NAMES) {
			try {
				cam = NIVision.IMAQdxOpenCamera(camName, 
						NIVision.IMAQdxCameraControlMode.CameraControlModeController);
				openCams.add(cam);
			} catch (Exception ex) {
				log.severe("Camera() failed to open the camera (" + camName + ")!");
			}
		}
	
		log.info("cam: " + cam);
		
		for(int cam : openCams) {
			NIVision.IMAQdxConfigureGrab(cam);				
			NIVision.IMAQdxStartAcquisition(cam);
		}
		
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		log.info("Camera started");
		
		server = CameraServer.getInstance();
		log.info("Got server");
		
		server.setQuality(50);
		
		log.info("Done camera init");
	}
	
	public ArrayList<Image> getImages() {
		ArrayList<Image> images = new ArrayList<Image>();
		for(int cam : openCams) {
			NIVision.IMAQdxGrab(cam, frame, 1);
		//	server.setImage(frame);
			images.add(frame);
		}
		return images;
	}

    public void initDefaultCommand() {
       	setDefaultCommand(new UpdateCam());
    }
}

