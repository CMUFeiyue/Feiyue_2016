package org.usfirst.frc.team9999.robot.subsystems;

import org.usfirst.frc.team9999.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Chassis extends Subsystem {
	private CANTalon masterLeft;
    private CANTalon slaveLeft;
    
    private CANTalon masterRight;
    private CANTalon slaveRight;
    
    private RobotDrive robotDrive;
    
    private double encOffsetValueRight = 0;
    private double encOffsetValueLeft = 0;
    
	private DigitalInput limitSwitch;
    
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Chassis(){
    	robotDrive = new RobotDrive(masterLeft, masterRight);

		// Set some safety controls for the drive system
		robotDrive.setSafetyEnabled(true);
		robotDrive.setExpiration(0.1);
		robotDrive.setSensitivity(0.5);
		robotDrive.setMaxOutput(1.0);
    	
    }
    
    public void driveByJoystick(double yDir, double xDir){
    	SmartDashboard.putString("driveByJoystick?", yDir + "," + xDir);
    	robotDrive.arcadeDrive(yDir, xDir);
    }
    
    public void printEncoderValues() {
		getEncoderDistance();
	}

	public double getEncoderRight() {
		System.out.println("getting encoder right");
		return -masterRight.getEncPosition();
	}

	public double getEncoderLeft() {
		System.out.println("getting encoder left");
		return masterLeft.getEncPosition();
	}

	public double getEncoderDistance() {
		
		System.out.println("getting distance");
		
		double numPulseLeft = getEncoderRight() - encOffsetValueLeft;
		double numPulseRight = getEncoderRight() - encOffsetValueRight;
			
		SmartDashboard.putNumber("Chassis Distance Right", (numPulseRight * RobotMap.DIST_PER_PULSE));
		SmartDashboard.putNumber("Chassis Distance Left", (numPulseLeft * RobotMap.DIST_PER_PULSE));
		
		return (numPulseRight) * RobotMap.DIST_PER_PULSE;
	}

	public void resetEncoderDistance() {
		encOffsetValueRight = getEncoderRight();
		encOffsetValueLeft = getEncoderLeft();
		getEncoderDistance();
	}
	
	public boolean isBumped() {
		return false;
    }
	
    public void stop() {
		robotDrive.drive(0, 0);
    } 
}

