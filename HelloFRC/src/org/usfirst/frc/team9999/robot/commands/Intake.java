package org.usfirst.frc.team9999.robot.commands;

import java.util.logging.Logger;

import org.usfirst.frc.team9999.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Intake extends Command {

	Logger logger = Logger.getLogger(this.getName());
	
    public Intake() {
    	requires(Robot.shooter);
    	logger.info("Intake init called");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	Robot.arm.dropArm();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.intake();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.shooter.stop();
    }
}
