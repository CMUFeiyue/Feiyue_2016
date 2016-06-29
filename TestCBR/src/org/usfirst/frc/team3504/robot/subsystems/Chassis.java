package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.RobotMap;
import org.usfirst.frc.team3504.robot.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {
	
	private CANTalon motor;
	
	private double encoderOffset = 0;
	
	public Chassis() {
		motor = new CANTalon(RobotMap.MOTOR);
		motor.enableBrakeMode(true);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DoNothing());
    }
    
    public void driveSpeed(double speed) {
		motor.set(speed);
	}
    
    public double getEncoderDistance() {
    	return (motor.getEncPosition() - encoderOffset) * RobotMap.DISTANCE_PER_PULSE;
    }
    
    public void resetEncoderDistance() {
    	encoderOffset = getEncoderDistance();
    }
    
    public void stop() {
    	motor.set(0);
    }
}

