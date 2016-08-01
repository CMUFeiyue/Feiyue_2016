package org.usfirst.frc.team9999.robot.commands;

import org.usfirst.frc.team9999.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class Shoot extends Command {
	
    public  DriveBackward() {
       
    	
    }

  protected void initialize() {
    }

   protected void execute() {
	  Robot.DRIVEMOTOR.backward();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

   
    protected void interrupted() {
    }
}

