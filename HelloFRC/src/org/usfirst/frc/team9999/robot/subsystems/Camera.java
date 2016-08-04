package org.usfirst.frc.team9999.robot.subsystems;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.usfirst.frc.team9999.robot.RobotMap;
import org.usfirst.frc.team9999.robot.commands.CamUpdate;

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
	private static final Logger logger = Logger.getLogger(Camera.class.getName());
	
	public Camera(){
		logger.setLevel(Level.ALL);
		logger.info("Cam initing");
		
		for(RobotMap.Camera camera : RobotMap.Camera.values()) {
			try {
				openCam(camera);
			} catch (Exception ex) {
				logger.warning("Failed to open the camera " + camera.toString());
			}finally{
				logger.info("Camera init complete");
			}
    	}
		
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);		
		server = CameraServer.getInstance();
		server.setQuality(50);
		logger.info("cam sub sys init complete");
	}
	
	public void openCam(RobotMap.Camera camera){
		int streamID = NIVision.IMAQdxOpenCamera(camera.getSysName(), 
				NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		camera.setStreamDescriptor(streamID);
		logger.info("Camera at: "+camera.toString()+" is opened");
		
		NIVision.IMAQdxConfigureGrab(streamID);				
		NIVision.IMAQdxStartAcquisition(streamID);
		logger.info("Camera at: "+camera.toString()+" configured");
	}
	
	public Image grabImage(RobotMap.Camera camera){
		int streamID = camera.getStreamDescriptor();
		if(streamID == RobotMap.Camera.INVALID_CAM){
			logger.warning("Camera at: "+camera.getSysName()+" IS NOT OPEN");
			return null;
		}else{
			NIVision.IMAQdxGrab(streamID, frame, 1);
			return frame;
		}
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new CamUpdate());
    }
}

