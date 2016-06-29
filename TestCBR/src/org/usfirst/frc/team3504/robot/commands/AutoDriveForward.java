package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class AutoDriveForward extends Command {
	
	private double distance;
	private double speed;

    public AutoDriveForward(double distance, double speed) {
    	requires(Robot.chassis);
    	this.distance = distance;
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Did I get this far?");
    	Robot.chassis.resetEncoderDistance();
    	System.out.println("Driving " + distance + " inches");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.driveSpeed(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.chassis.getEncoderDistance() >= Math.abs(distance);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.stop();
    	System.out.println("Done");
    	Scheduler.getInstance().removeAll();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
