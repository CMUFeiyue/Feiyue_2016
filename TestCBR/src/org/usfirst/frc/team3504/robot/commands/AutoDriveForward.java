package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class AutoDriveForward extends Command {
	
	private double distance;
	private double speed;

    public AutoDriveForward(double distance, double speed) {
    	requires(Robot.chassis);
    	this.distance = distance;
    	this.speed = speed;
    }

    protected void initialize() {
    	System.out.println("Did I get this far?");
    	Robot.chassis.resetEncoderDistance();
    	System.out.println("Driving " + distance + " inches");
    }

    protected void execute() {
    	Robot.chassis.driveSpeed(speed);
    }

    protected boolean isFinished() {
        return Robot.chassis.getEncoderDistance() >= Math.abs(distance);
    }

    protected void end() {
    	Robot.chassis.stop();
    	System.out.println("Done");
    	Scheduler.getInstance().removeAll();
    }

    protected void interrupted() {
    	end();
    }
}