package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class DriveMotor extends Subsystem {

	private static CANTalon driveMaster, driveSlave;
	NetworkTable table = NetworkTable.getTable("datatable");
	
	//PID constants
	public double kP;
	public double kI;
	public double kD;
	public double f;
	public int izone;
	public double closeLoopRampRate;
	public int profile;
	
	public double speed;
			
	public DriveMotor()
	{
		driveMaster = new CANTalon(RobotMap.DRIVE_MASTER);
		driveSlave = new CANTalon(RobotMap.DRIVE_SLAVE);
		
		//initial values for PID
		kP = 1;
		kI = 0;
		kD = 20;
		f = 1;
		izone = 0;
		closeLoopRampRate = 0;
		profile = 0;
				
		speed = 0.1;
		
		driveMaster.changeControlMode(CANTalon.TalonControlMode.Speed);
		driveSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		driveSlave.set(driveMaster.getDeviceID());
		setPID();
	}
	
	public void forward() {
		System.out.println("speed" + speed);
 	   	driveMaster.set(speed);
	}

	public void stop() {
		driveMaster.set(0);
	}
	
	public void updatePIDValues() {
		this.kP = table.getNumber("kP", 0);
		this.kI = table.getNumber("kI", 0);
		this.kD = table.getNumber("kD", 0);
		this.f = table.getNumber("f", 0);
		this.izone = (int) table.getNumber("izone", 0);
		this.closeLoopRampRate = table.getNumber("closeLoopRampRate", 0);
		this.profile = (int) table.getNumber("profile", 0);
		
		setPID();
	}
	
	public void setPID() {
		driveMaster.setPID(kP, kI, kD, f, izone, closeLoopRampRate, profile);
	}
	
	public int getEncoderPosition() {
		return driveMaster.getEncPosition();
	}
	
	public int getEncoderVelocity() {			
		return driveMaster.getEncVelocity();
	}
	
	public double getPlotValue() {
		return getEncoderVelocity();
	}
	
	public void initDefaultCommand() {
		
	}

}



