package org.usfirst.frc.team9999.robot.commands;

import java.util.logging.Logger;

import org.usfirst.frc.team9999.robot.Robot;
import org.usfirst.frc.team9999.robot.RobotMap;
import org.usfirst.frc.team9999.robot.subsystems.Camera;

import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CamUpdate extends Command {
	
	private boolean shooterEnabled = true;
	private static final Logger logger = Logger.getLogger(Camera.class.getName());
	private Thread checker;

    public CamUpdate() {
        requires(Robot.camera);
        checker = new Thread(()->{
        	while(true){
        		if(Robot.oi.changeCam()){
        			shooterEnabled = !shooterEnabled;
        			try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						logger.warning("cam sleep interrupted:"+e.getMessage());
					}
        		}
        	}
        });
        checker.start();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Image img = Robot.camera.grabImage(shooterEnabled ? 
    			RobotMap.Camera.SHOOTER_CAM
    			:RobotMap.Camera.FORWARD_CAM);
    	
    	if(img != null) {
    		CameraServer.getInstance().setImage(img);
    		logger.info("grab done");
    	}
    	else {
    		logger.warning("No image was grabbed");
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
