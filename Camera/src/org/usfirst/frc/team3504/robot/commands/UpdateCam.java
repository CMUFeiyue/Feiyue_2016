package org.usfirst.frc.team3504.robot.commands;

import java.util.logging.Logger;

import org.usfirst.frc.team3504.robot.Robot;
import org.usfirst.frc.team3504.robot.subsystems.Camera;

import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UpdateCam extends Command {

	public final static Logger log = Logger.getLogger(UpdateCam.class.getName());

    public UpdateCam() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.camera);
    	requires(Robot.vision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	log.info("Grabbing image");
    	Image img = Robot.camera.getImage();
    	
    	if(img != null) {
    		log.info("Processing image");
    		Robot.vision.findTote(img);
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
