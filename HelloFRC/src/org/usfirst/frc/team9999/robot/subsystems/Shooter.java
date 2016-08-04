package org.usfirst.frc.team9999.robot.subsystems;

import java.util.logging.Logger;

import org.usfirst.frc.team9999.robot.RobotMap;
//import org.usfirst.frc.team9999.robot.commands.Intake;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

	private static final double speedIn = -1;									//TODO : check this!!!
	private static final double speedOut = 1;									//TODO : check this!!!
	private DoubleSolenoid pusher;
	private CANTalon spinnerL,spinnerR;
	private Logger logger = Logger.getLogger(this.getName());
	private boolean isIntaking = false;
	
	public Shooter(){
		pusher = new DoubleSolenoid(RobotMap.PUSHER_SOLENOID_FWD,RobotMap.PUSHER_SOLENOID_BWD);
		spinnerL = new CANTalon(RobotMap.SPINNER_L_PORT);
		spinnerR = new CANTalon(RobotMap.SPINNER_R_PORT);
		pusher.set(DoubleSolenoid.Value.kReverse);
        logger.info("shooter initalizing");
	}

    public void initDefaultCommand() {
//        setDefaultCommand(new Intake());
    }
    
    public void shoot(){		//TODO check this
    	logger.info("shooting!!!");
    	isIntaking = false;
    	spinnerL.set(speedOut);
    	spinnerR.set(-speedOut);
    	try{
    		Thread.sleep(2000);
    	}catch (InterruptedException e){
    		Logger.getLogger(this.getName()).warning("shoot sleep interruped"+e.getMessage());
    	}
    	pusher.set(DoubleSolenoid.Value.kForward);
		logger.info("shooter state: shooting");
    	try{
    		Thread.sleep(200);
    	}catch (InterruptedException e){
    		Logger.getLogger(this.getName()).warning("shoot sleep interruped"+e.getMessage());
    	}
    	stop();
    }
    
    public void intake(){
    	if(isIntaking){
    		stop();
    	}else{
        	spinnerL.set(speedIn);
        	spinnerR.set(-speedIn);
    	}
    	isIntaking = !isIntaking;
//    	stop();
		logger.info("shooter state: intaking");
    }
    
    public void stop(){
    	spinnerL.set(0);
    	spinnerR.set(0);
    	pusher.set(DoubleSolenoid.Value.kReverse);
		logger.info("shooter state: stopping");
    }
}
/**/
