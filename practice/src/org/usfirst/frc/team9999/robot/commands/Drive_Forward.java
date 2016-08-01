package org.usfirst.frc.team9999.robot.commands;

import org.usfirst.frc.team9999.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
public class Drive_Forward extends Command {

    public Drive_Forward() {
    	requires(Robot.DRIVEMOTOR);
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    	Robot.DRIVEMOTOR.forward();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.DRIVEMOTOR.stop();
    }

    protected void interrupted() {
    }
}
