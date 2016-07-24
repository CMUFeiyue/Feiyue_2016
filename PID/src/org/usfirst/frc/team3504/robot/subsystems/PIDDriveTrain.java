package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.Robot;
import org.usfirst.frc.team3504.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDDriveTrain extends PIDSubsystem {

	private CANTalon driveMaster;
	private CANTalon driveSlave;
	
	private static String name;
	private double kP;
	private double kI;
	private double kD;
	private double f;
	
	public PIDDriveTrain(String name, double kP, double kI, double kD, double f) {
		super(name, kP, kI, kD, f);
	}
	
	public PIDDriveTrain() {
    	this("DriveTrain", 0.1, 1, 0, 0);
    	
    	name = "DriveTrain";
    	kP = 0.1;
    	kI = 1;
    	kD = 0;
    	f = 0;
    	
    	printPIDValues();
    	
    	driveMaster = new CANTalon(RobotMap.DRIVE_MASTER);
		driveSlave = new CANTalon(RobotMap.DRIVE_SLAVE);
		
	//	driveMaster.changeControlMode(CANTalon.TalonControlMode.Speed);
		
		driveSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		driveSlave.set(driveMaster.getDeviceID());
		
		driveMaster.setPIDSourceType(PIDSourceType.kRate);
		
    	System.out.println(driveMaster.getPIDSourceType());
    	System.out.println(driveMaster.getControlMode());
		
    	setInputRange(-1, 1);
		//setAbsoluteTolerance(0.1);
	//	setToleranceBuffer(20);
    	setPercentTolerance(10);
    	getPIDController().setContinuous(false);
    	
    //	Robot.lw.addActuator("Motor", "PID Controller", getPIDController());
    	LiveWindow.addActuator("Motor", "PID Controller", getPIDController());
    	//SmartDashboard.putNumber("error", 0);
    }
    
    public void initDefaultCommand() {
    
    }
    
    protected double returnPIDInput() {
//    	System.out.println(driveMaster.getEncVelocity());
    	//return driveMaster.getEncVelocity();
    	return driveMaster.getOutputVoltage() / driveMaster.getBusVoltage();
    	//return driveMaster.getEncVelocity();
    }
    
    protected void usePIDOutput(double output) {
    	//System.out.println(output);
    	driveMaster.pidWrite(output);
    }
    
    public void updatePIDValues() {
		this.kP = SmartDashboard.getNumber("kP", 0);
		this.kI = SmartDashboard.getNumber("kI", 0);
		this.kD = SmartDashboard.getNumber("kD", 0);
		this.f = SmartDashboard.getNumber("f", 0);

		setPID();
	}
    
    public void printPIDValues() {
 		SmartDashboard.putNumber("kP", kP);
 		SmartDashboard.putNumber("kI", kI);
 		SmartDashboard.putNumber("kD", kD);
 		SmartDashboard.putNumber("f", f);
 	}
     
    public void setPID() {
		getPIDController().setPID(kP, kI, kD, f);
	}
    
    public void printInfo() {
    	SmartDashboard.putNumber("error", getPIDController().getError());
    	Robot.table.putNumber("error", getPIDController().getError());
    	System.out.println(this.returnPIDInput() + "  " + getPIDController().getError()
    			+ "   "  + getPIDController().onTarget());
    }

}