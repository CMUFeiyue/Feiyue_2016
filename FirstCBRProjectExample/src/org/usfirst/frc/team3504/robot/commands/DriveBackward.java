package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3504.robot.Robot;

public class DriveBackward extends Command {

    public DriveBackward() {
    	requires(Robot.driveMotor);
    }


    protected void initialize() {
    }

    protected void execute() {
    	Robot.driveMotor.backward();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.driveMotor.stop();
    }

    protected void interrupted() {
    }
}
