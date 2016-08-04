package org.usfirst.frc.team9999.robot.subsystems;

//import org.usfirst.frc.team9999.robot.RobotMap;
//import org.usfirst.frc.team9999.robot.commands.AutoControl;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoChassis extends PIDSubsystem {

	private double kp;
	private double ki;
	private double kd;
	private double f;

	private CANTalon master;
	private CANTalon slave;
    
    public AutoChassis(double kp,double ki,double kd,double f,int masterPort,int slavePort){
    	super(kp,ki,kd,f);
    	this.kd = kd;
    	this.ki = ki;
    	this.kd = kd;
    	this.f = f;
    	printPIDValues();

    	master = new CANTalon(masterPort);
    	slave = new CANTalon(slavePort);
    	
    	slave.changeControlMode(CANTalon.TalonControlMode.Follower);
    	slave.set(master.getDeviceID());
    }    
    
    public void printPIDValues() {
    	SmartDashboard.putNumber("kP", kp);
		SmartDashboard.putNumber("kI", ki);
		SmartDashboard.putNumber("kD", kd);
		SmartDashboard.putNumber("f", f);
	}
        
    public void setPIDValues() {
		kp = SmartDashboard.getNumber("kP");
		ki = SmartDashboard.getNumber("kI");
		kd = SmartDashboard.getNumber("kD");
		f = SmartDashboard.getNumber("f");
	}
    
    public void setPID() {
		getPIDController().setPID(kp, ki, kd, f);
	}
    
    protected double returnPIDInput() {
    	return master.getOutputVoltage()/master.getBusVoltage();
    }
    
    protected void usePIDOutput(double output) {
    	master.pidWrite(output);
    }
    
    public void setSetSpeed(double setSp){
    	master.setSetpoint(setSp);
    }

	protected void initDefaultCommand() {}
}
