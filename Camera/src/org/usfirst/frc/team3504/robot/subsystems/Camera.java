package org.usfirst.frc.team3504.robot.subsystems;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.usfirst.frc.team3504.robot.commands.UpdateCam;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

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
			cam = NIVision.IMAQdxOpenCamera("cam0", 
					NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		} catch (Exception ex) {
			log.severe("Camera() failed to open the camera (cam0)!");
			cam = INVALID_CAMERA;
		}
		
		if (cam != INVALID_CAMERA) {
			NIVision.IMAQdxConfigureGrab(cam);				
			NIVision.IMAQdxStartAcquisition(cam);
		}
		
		log.info("Camera started");
		
		server = CameraServer.getInstance();
		server.setQuality(50);
	}
	
	public Image getImage() {
		if (cam != INVALID_CAMERA) {
			NIVision.IMAQdxGrab(cam, frame, 1);
			server.setImage(frame);
			return frame;
		}
		return null;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new UpdateCam());
    }
}

