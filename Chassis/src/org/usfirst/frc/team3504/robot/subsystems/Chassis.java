package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.RobotMap;
import org.usfirst.frc.team3504.robot.commands.DriveByJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chassis extends Subsystem {
    private CANTalon masterLeft;
    private CANTalon slaveLeft;
    
    private CANTalon masterRight;
    private CANTalon slaveRight;
    
    private RobotDrive robotDrive;
    
    private double encOffsetValueRight = 0;
    private double encOffsetValueLeft = 0;
    
    public Chassis() {
    	masterLeft = new CANTalon(RobotMap.MASTER_LEFT);
		slaveLeft = new CANTalon(RobotMap.SLAVE_LEFT);
		
		masterRight = new CANTalon(RobotMap.MASTER_RIGHT);
		slaveRight = new CANTalon(RobotMap.SLAVE_RIGHT);
		
		
		masterLeft.enableBrakeMode(true);
		slaveLeft.enableBrakeMode(true);
		
		masterRight.enableBrakeMode(true);
		slaveRight.enableBrakeMode(true);
		
		
		slaveLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		slaveLeft.set(masterLeft.getDeviceID());
		
		slaveRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		slaveRight.set(masterRight.getDeviceID());
		
		robotDrive = new RobotDrive(masterLeft, masterRight);

		// Set some safety controls for the drive system
		robotDrive.setSafetyEnabled(true);
		robotDrive.setExpiration(0.1);
		robotDrive.setSensitivity(0.5);
		robotDrive.setMaxOutput(1.0);

    }
    
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveByJoystick());
    }
    
    public void driveByJoystick(double move, double rotate){
    	SmartDashboard.putString("driveByJoystick?", move + "," + rotate);
    	robotDrive.arcadeDrive(move, rotate);
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
    
    public void stop() {
		robotDrive.drive(0, 0);
	}
}

