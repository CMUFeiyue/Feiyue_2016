
package org.usfirst.frc.team9999.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.logging.Logger;

import org.usfirst.frc.team9999.robot.Robot;

/**
 *
 */
public class Move extends Command {
	
	private Logger logger;

    public Move() {
        requires(Robot.chassis);
        logger = Logger.getLogger(Move.class.getName());
    }

    protected void initialize() {
    	SmartDashboard.putString("Move state:", "initializing");
    	logger.info("Move state: initializing");
    }

    protected void execute() {
    	Robot.chassis.moveByJoystick();
//    	SmartDashboard.putNumber("Left Vol:", Robot.chassis.getVoltage(true));
//    	SmartDashboard.putNumber("Right Vol:", Robot.chassis.getVoltage(false));
    	SmartDashboard.putString("Move state:", "running");
    	SmartDashboard.putNumber("Left Vol:", Robot.chassis.getVoltage(true));
    	SmartDashboard.putNumber("Right Vol:", Robot.chassis.getVoltage(false));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.oi.isStoped();
    }
    
    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	SmartDashboard.putString("Move state:", "interrupted");
    }
}
