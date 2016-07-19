package org.usfirst.frc.team3504.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Solenoid extends Subsystem {

	private static DoubleSolenoid doubleSolenoid;
				
	public Solenoid() {
		doubleSolenoid = new DoubleSolenoid(2, 3);
	}
	
	public void initDefaultCommand() {
	
	}
	
	public void close(){ 							
		doubleSolenoid.set(DoubleSolenoid.Value.kForward);	
	}

	public void open(){						
		doubleSolenoid.set(DoubleSolenoid.Value.kReverse); 	
	}

	public void stop()
	{
		doubleSolenoid.set(DoubleSolenoid.Value.kOff);
	}
}