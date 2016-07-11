package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class UpdateCam extends Command {
	
    public UpdateCam() {
        requires(Robot.camera);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    //	Robot.camera.getImage();
    	Robot.camera.readNetworkTable();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    	end();
    }
}