package org.usfirst.frc.team9999.robot.subsystems;

import java.util.logging.Level;
import java.util.logging.Logger;

//import org.usfirst.frc.team9999.robot.Robot;
import org.usfirst.frc.team9999.robot.RobotMap;
//import org.usfirst.frc.team9999.robot.commands.ToggleArm;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
    
	private boolean isLift = false;
	private Logger logger = Logger.getLogger(this.getName());
	
	private DoubleSolenoid pistonL,pistonR;
	
	public Arm(){
		pistonL = new DoubleSolenoid(RobotMap.SOLENOIDL_FWD, RobotMap.SOLENOIDL_BWD);
		pistonR = new DoubleSolenoid(RobotMap.SOLENOIDR_FWD, RobotMap.SOLENOIDR_BWD);
		logger.setLevel(Level.ALL);
		dropArm();
		logger.info("Arm initalizing");
	}

    public void initDefaultCommand() {
//    	setDefaultCommand(new ToggleArm());
    }
    
    public void liftArm(){
    	pistonL.set(DoubleSolenoid.Value.kForward);
    	pistonR.set(DoubleSolenoid.Value.kForward);
		logger.info("arm state: lifting");
    }
    
    public void dropArm(){
    	pistonL.set(DoubleSolenoid.Value.kReverse);
    	pistonR.set(DoubleSolenoid.Value.kReverse);
		logger.info("arm state: dropping");
    }
    
	public void disableAll() {
//		pistonL.set(DoubleSolenoid.Value.kOff);
//		pistonR.set(DoubleSolenoid.Value.kOff);
	}

	public void toggleArmPosition() {
		if(isLift){
			dropArm();
		}else{
			liftArm();
		}
		isLift = !isLift;
		logger.info("arm state"+(isLift?"up":"down"));
	}
}
/**/
