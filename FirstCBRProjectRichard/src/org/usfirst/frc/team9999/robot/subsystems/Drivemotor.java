package org.usfirst.frc.team9999.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team9999.robot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
public class Drivemotor extends Subsystem {
    private static CANTalon motor;
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
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

    

