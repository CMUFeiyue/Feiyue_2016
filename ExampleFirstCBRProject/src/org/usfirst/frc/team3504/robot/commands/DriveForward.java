package org.usfirst.frc.team3504.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3504.robot.Robot;

public class DriveForward extends Command {

    public DriveForward() {
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
