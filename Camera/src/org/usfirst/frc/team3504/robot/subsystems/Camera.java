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
	
	
	private static final int INVALID_CAMERA = -1;
	
	public Camera() {
		try {
			camClaw = NIVision.IMAQdxOpenCamera("cam0", 
					NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		} catch (Exception ex) {
			System.out.println("Camera() failed to open the claw camera (cam0)!!");
			cam = INVALID_CAMERA;
		}
		try {
			camFlap = NIVision.IMAQdxOpenCamera("cam", 
					NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		}
				
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		
		server = CameraServer.getInstance();
		server.setQuality(50);
		
		switchToCamera(curCam);
		// Don't call startAutomaticCapture() here because we're using setImage() instead
	}
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

