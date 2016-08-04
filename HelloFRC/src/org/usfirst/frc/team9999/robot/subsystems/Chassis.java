
package org.usfirst.frc.team9999.robot.subsystems;

import org.usfirst.frc.team9999.robot.Robot;
import org.usfirst.frc.team9999.robot.RobotMap;
import org.usfirst.frc.team9999.robot.commands.Move;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *@author Wilson
 */
public class Chassis extends Subsystem {
    
	private static boolean isStopped = false;
	
	private CANTalon motorR
			,slaveR
			,motorL
			,slaveL;
	
	
	public Chassis(){
		
		motorL = new CANTalon(RobotMap.MOTORL_PORT);
		slaveL = new CANTalon(RobotMap.SLAVEL_PORT);
		
		slaveL.changeControlMode(CANTalon.TalonControlMode.Follower);
		slaveL.set(motorL.getDeviceID());
		
		motorR = new CANTalon(RobotMap.MOTORR_PORT);
		slaveR = new CANTalon(RobotMap.SLAVER_PORT);
		
		slaveR.changeControlMode(CANTalon.TalonControlMode.Follower);
		slaveR.set(motorR.getDeviceID());

		motorR.enableBrakeMode(true);
		motorL.enableBrakeMode(true);
		slaveR.enableBrakeMode(true);
		slaveL.enableBrakeMode(true);		
	}
	
	public double getVoltage(boolean isLeft){
		return (isLeft? motorR.getOutputVoltage() : motorR.getOutputVoltage());
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new Move());
    }
    
    public void moveByJoystick(){
    	moveByGivenValues(Robot.oi.getX(),Robot.oi.getY());
    }

    /*set power by given values. examples:
     * (0,0) :won't move
     * (-1,0):left motor reverse at full speed, right motor forward at full speed.
     * (1,0) :left forward, right reverse
     * (1,1) :left forward, right stopped
     * (0.5,0.3):left 0.8, right 0.2
     */
    private void moveByGivenValues(double joystickXPosition,double joystickYPosition){
    	motorL.set(-(joystickXPosition+joystickYPosition>1 ?
    				1:
    				(joystickXPosition+joystickYPosition<-1 ?
    						-1:
    						joystickXPosition+joystickYPosition)));
    	motorR.set(-joystickXPosition+joystickYPosition>1 ?
    				1:
    				(-joystickXPosition+joystickYPosition<-1 ?
    						-1
    						:-joystickXPosition+joystickYPosition));
    }
    
    public boolean isEmergencyStopped(){
    	return isStopped;
    }
    
    public void stop(){
    	motorR.set(0);
    	motorL.set(0);
    }
}

