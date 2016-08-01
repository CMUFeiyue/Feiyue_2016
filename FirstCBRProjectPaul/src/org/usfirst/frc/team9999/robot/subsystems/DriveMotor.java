package org.usfirst.frc.team9999.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team9999.robot.Robot;
import org.usfirst.frc.team9999.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;


public class DriveMotor extends Subsystem {
	private static CANTalon motor;

	public DriveMotor() {
		
		     motor = new CANTalon(RobotMap.MOTOR_PORT);
		     requires(Robot.DRIVEMOTOR);
		}

	
	private void requires(DriveMotor drivemotor) {
		// TODO Auto-generated method stub
		
	}


	public void stop(){
		
		motor.set(0);
	}
	
	public void forward(){
		
		motor.set(0.5);
		
	}
	
	public void backward(){
		
		motor.set(-0.5);
		
	}
 

    public void initDefaultCommand() {
      
    }
}


