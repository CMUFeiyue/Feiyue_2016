package org.usfirst.frc.team9999.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team9999.robot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
/** 
 * 
 */
public class DriverMotor extends Subsystem {
private static CANTalon motor;
public DriverMotor(){
	motor = new CANTalon(RobotMap.MOTOR_PORT);
}
public void forward() {
	motor.set(0.4);
}
public void backward() {
	motor.set(-0.4);
}
public void stop(){
	motor.set(0);
}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

