package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class TunablePIDSubsystem extends PIDSubsystem {

	private static String name;
	private double kP;
	private double kI;
	private double kD;
	private double f;
	
	public TunablePIDSubsystem(String name, double kP, double kI, double kD, double f) {
		super(name, kP, kI, kD, f);
	  	
		this.name = name;
    	this.kP = kP;
    	this.kI = kI;
    	this.kD = kD;
    	this.f = f;
    	
    	printPIDValues();
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
    
    public String toString() {
    	return name;
    }
}
