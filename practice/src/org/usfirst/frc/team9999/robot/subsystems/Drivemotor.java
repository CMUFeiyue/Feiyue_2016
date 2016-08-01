package org.usfirst.frc.team9999.robot.subsystems;

import org.usfirst.frc.team9999.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivemotor extends Subsystem {
	
	private static CANTalon motor;
    public void initDefaultCommand() {
    }
	
	public Drivemotor(){
		motor = new CANTalon(RobotMap.MOTOR_PORT);
	}
	
	public void forward(){
		motor.set(0.4);
	}
	
	public void backward(){
		motor.set(-0.4);
	}
	
	public void stop(){
		motor.set(0);
	}


}

