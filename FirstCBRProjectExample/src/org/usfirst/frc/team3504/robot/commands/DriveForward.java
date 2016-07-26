package org.usfirst.frc.team3504.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3504.robot.Robot;

public class DriveForward extends Command {

    public DriveForward() {
    	requires(Robot.driveMotor);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.driveMotor.forward();
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
