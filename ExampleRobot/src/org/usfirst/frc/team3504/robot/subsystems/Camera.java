package org.usfirst.frc.team3504.robot.subsystems;

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
//	private NetworkTable table;
	private Image frame;
	private int cam;
	public final static Logger log = Logger.getLogger(Camera.class.getName());
	
	private static final int INVALID_CAMERA = -1;
	
	public Camera() {
		log.setLevel(Level.ALL);
		log.info("Camera init");
		
		try {
			cam = NIVision.IMAQdxOpenCamera(RobotMap.CAMERA_NAME, 
					NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		} catch (Exception ex) {
			log.severe("Camera() failed to open the camera (" + RobotMap.CAMERA_NAME + ")!");
			cam = INVALID_CAMERA;
		}
		
		log.info("cam: " + cam);
		
		if (cam != INVALID_CAMERA) {
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
	
	public Image getImage() {
		if (cam != INVALID_CAMERA) {
			NIVision.IMAQdxGrab(cam, frame, 1);
		//	server.setImage(frame);
			return frame;
		}
		return null;
	}

    public void initDefaultCommand() {
       	setDefaultCommand(new UpdateCam());
    }
}

