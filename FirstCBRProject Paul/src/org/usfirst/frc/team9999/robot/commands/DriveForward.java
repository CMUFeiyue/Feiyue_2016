package org.usfirst.frc.team9999.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team9999.robot.Robot;


public class DriveForward extends Command {
	
    public  DriveForward() {
       
    	
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
    }

   
    protected void interrupted() {
    }
   
}

