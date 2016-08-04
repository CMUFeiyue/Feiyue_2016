package org.usfirst.frc.team9999.robot.commands;

import org.usfirst.frc.team9999.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {

    public DriveForward() {
//        requires(Robot.autoL);
//        requires(Robot.autoR);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.setTimeout(5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.autoL.setSetpoint(0.5);
    	Robot.autoR.setSetpoint(0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
