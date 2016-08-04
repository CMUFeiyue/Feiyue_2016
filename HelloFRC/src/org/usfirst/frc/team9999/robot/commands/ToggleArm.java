package org.usfirst.frc.team9999.robot.commands;

import java.util.logging.Logger;

import org.usfirst.frc.team9999.robot.Robot;
//import org.usfirst.frc.team9999.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ToggleArm extends Command {
	
    public ToggleArm() {
    	requires(Robot.arm);
    }

    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.arm.toggleArmPosition();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        return Robot.oi.isStoped();
    	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.arm.disableAll();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
		Logger.getLogger(this.getName()).warning("ArmMovement interrupted");
		SmartDashboard.putString("ArmMovment", "interrupted");
    }
}
/**/