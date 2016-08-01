package org.usfirst.frc.team9999.robot.commands;

import org.usfirst.frc.team9999.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SolenoidForward extends Command {

    public SolenoidForward() {
        requires(Robot.ARM);
    }// constructor is method

    protected void initialize() {
    	
    }

    protected void execute() {
    	Robot.ARM.open();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.ARM.stop();
    }

    protected void interrupted() {
    }
    
    
}
