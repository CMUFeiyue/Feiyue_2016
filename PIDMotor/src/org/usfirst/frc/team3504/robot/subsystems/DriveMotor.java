package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.Robot;
import org.usfirst.frc.team3504.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveMotor extends Subsystem {

	private static CANTalon motor;
	public double kP;
	public double kI;
	public double kD;
	public double F;
	public double SP;
			
	public DriveMotor()
	{
		motor = new CANTalon(RobotMap.MOTOR_PORT);
		
		kP = 1;
		kI = 0.1;
		kD = 20;
		F = 1;
		SP = 0.1;
	
		motor.changeControlMode(CANTalon.TalonControlMode.Speed);
		motor.setPID(kP, kI, kD, F, 0, 0, 0);
	}
	
	public void forward(){
		SmartDashboard.putNumber("Closed Loop Error", motor.getClosedLoopError());
		
		SmartDashboard.putNumber("P", motor.getP());
		SmartDashboard.putNumber("I", motor.getI());
		SmartDashboard.putNumber("D", motor.getD());
		SmartDashboard.putNumber("F", motor.getF());
		SmartDashboard.putNumber("Setpoint", motor.getSetpoint());
		
		SmartDashboard.putNumber("Encoder 1 Position", Robot.driveMotor.Wheel1EncoderPosition());
 	    SmartDashboard.putNumber("Encoder 1 Velocity", Robot.driveMotor.Wheel1EncoderVelocity());  

 	    SmartDashboard.putNumber("Encoder 1 Velocity Graph", Robot.driveMotor.Wheel1EncoderVelocity());
 	   	SmartDashboard.putNumber("Encoder 1 Position Graph", Robot.driveMotor.Wheel1EncoderPosition());

 	   	motor.set(SP);
	}

	public void stop()
	{
		motor.set(0);
	}
	
	public int Wheel1EncoderPosition() {
		return motor.getEncPosition();
	}
	
	public int Wheel1EncoderVelocity() {			
		return motor.getEncVelocity();
	}
	
	public void initDefaultCommand() {
		
	}

}



