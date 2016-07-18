package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.Robot;
import org.usfirst.frc.team3504.robot.RobotMap;
import org.usfirst.frc.team3504.robot.commands.DriveByJoystick;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Chassis extends Subsystem {
    private CANTalon driveLeftA;
    private CANTalon driveLeftB;
    
    private CANTalon driveRightA;
    private CANTalon driveRightB;
    
    private RobotDrive robotDrive;
    
    private double encOffsetValueRight = 0;
    private double encOffsetValueLeft = 0;
    
    try {
		/* Communicate w/navX MXP via the MXP SPI Bus.                                     */
		/* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
		/* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
		ahrs = new AHRS(SPI.Port.kMXP);
	}
    
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveByJoystick());
    }
    
    public void driveByJoystick(double Y, double X){
    	SmartDashboard.putString("driveByJoystick?", Y + "," + X);
    	robotDrive.arcadeDrive(Y,X);
    }
    
    public void printEncoderValues() {
		getEncoderDistance();
	}

	public double getEncoderRight() {
		return -driveRightA.getEncPosition();
	}

	public double getEncoderLeft() {
		return driveLeftA.getEncPosition();
	}

	public double getEncoderDistance() {
		if (Robot.shifters.getGearSpeed()) {
			SmartDashboard.putNumber("Chassis Encoders Right", (getEncoderRight() - encOffsetValueRight) * RobotMap.DISTANCE_PER_PULSE_HIGH_GEAR);
			SmartDashboard.putNumber("Chassis Encoders Left", (getEncoderLeft() - encOffsetValueLeft) * RobotMap.DISTANCE_PER_PULSE_HIGH_GEAR);
			return (getEncoderRight() - encOffsetValueRight) * RobotMap.DISTANCE_PER_PULSE_HIGH_GEAR;
		}
		else {
			SmartDashboard.putNumber("Chassis Encoders Right", (getEncoderRight() - encOffsetValueRight) * RobotMap.DISTANCE_PER_PULSE_LOW_GEAR);
			SmartDashboard.putNumber("Chassis Encoders Left", (getEncoderLeft() - encOffsetValueLeft) * RobotMap.DISTANCE_PER_PULSE_LOW_GEAR);
			return (getEncoderRight() - encOffsetValueRight) * RobotMap.DISTANCE_PER_PULSE_LOW_GEAR;
		}
	}

	public void resetEncoderDistance() {
		encOffsetValueRight = getEncoderRight();
		encOffsetValueLeft = getEncoderLeft();
		ahrs.resetDisplacement();
		getEncoderDistance();
	}
    public void stop() {
		robotDrive.drive(0, 0);
	}
}

