package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3504.robot.Robot;

public class DriveBackward extends Command {

    public DriveBackward() {
    	requires(Robot.DRIVEMOTOR);
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
    	Robot.DRIVEMOTOR.stop();
    }

    protected void interrupted() {
    }
}
