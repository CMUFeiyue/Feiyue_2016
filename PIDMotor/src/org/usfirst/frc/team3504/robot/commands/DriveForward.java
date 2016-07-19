package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveForward extends Command {
   
	public static double P;
    public static double I;
    public static double D;
    public static double F;
    
	public DriveForward() {
    	requires(Robot.driveMotor);
    	
    }
	
    protected void initialize() {
    }

	protected void execute() {
    	Robot.driveMotor.forward();  	
    	 
 	   	SmartDashboard.putNumber("Encoder 1 Position", Robot.driveMotor.Wheel1EncoderPosition());
 	    SmartDashboard.putNumber("Encoder 1 Velocity", Robot.driveMotor.Wheel1EncoderVelocity());  

 	    SmartDashboard.putNumber("Encoder 1 Velocity Graph", Robot.driveMotor.Wheel1EncoderVelocity());
 	   	SmartDashboard.putNumber("Encoder 1 Position Graph", Robot.driveMotor.Wheel1EncoderPosition());

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveMotor.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    }

