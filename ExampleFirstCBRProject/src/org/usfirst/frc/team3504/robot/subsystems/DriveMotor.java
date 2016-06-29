package org.usfirst.frc.team3504.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3504.robot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;

public class DriveMotor extends Subsystem {
    
	private static CANTalon motor;
	
	public DriveMotor() {
		motor = new CANTalon(RobotMap.MOTOR_PORT);
	}
	
	// spins the motor forward
	public void forward() {
		motor.set(0.4);
	}
	
	// spins the motor backward
	public void backward() {
		motor.set(-0.4);
	}
	
	// stops spinning the motor
	public void stop() {
		motor.set(0);
	}
	
    public void initDefaultCommand() {

    }
}

