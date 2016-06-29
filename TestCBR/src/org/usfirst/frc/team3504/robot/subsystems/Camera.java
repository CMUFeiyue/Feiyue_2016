package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.commands.UpdateCam;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import java.util.logging.*;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Camera extends Subsystem {
    
	private CameraServer server;
	private Image frame;
	private int cam;
	
	private static final int INVALID_CAMERA = -1;
	
	public Camera() {
		try {
			cam = NIVision.IMAQdxOpenCamera("cam0", 
					NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		} catch (Exception ex) {
			//log.error("Camera() failed to open the camera (cam0)!!");
			cam = INVALID_CAMERA;
		}
				
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		
		server = CameraServer.getInstance();
		server.setQuality(50);
		
		if (cam != INVALID_CAMERA) {
			NIVision.IMAQdxConfigureGrab(cam);
			NIVision.IMAQdxStartAcquisition(cam);
		}
	}
	
	/* Grab a new image from the current camera, putting it into the frame.
	 * Then set that as the current frame in the camera server.
	 * If we don't have a working camera, just skip the whole process.
	 */
	public void getImage() {
		if (cam != INVALID_CAMERA) {
			NIVision.IMAQdxGrab(cam, frame, 1);
			server.setImage(frame);
		}
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new UpdateCam());
    }
}