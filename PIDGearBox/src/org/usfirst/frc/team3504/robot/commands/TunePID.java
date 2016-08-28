package org.usfirst.frc.team3504.robot.commands;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.usfirst.frc.team3504.robot.Robot;
import org.usfirst.frc.team3504.robot.subsystems.TunablePIDSubsystem;
import edu.wpi.first.wpilibj.command.Command;

public class TunePID<T extends TunablePIDSubsystem> extends Command {

	private ArrayList<Double> values;
	private ArrayList<Double> times;
	private T PIDSubsystem;
	
	public final static Logger log = Logger.getLogger(TunePID.class.getName());	
	
	public TunePID (T PIDSubsystem) {
    	this.requires(PIDSubsystem);
		log.setLevel(Level.ALL);
		this.PIDSubsystem = PIDSubsystem;
    }

    protected void initialize() {
    	log.info("init");
    	values = new ArrayList<Double>();
    	times = new ArrayList<Double>();
    	
    	PIDSubsystem.updatePIDValues();

    	//double timeout = table.getNumber("timeout", 0);

    	double timeout = 5;
    	this.setTimeout(timeout);
		log.info("running");
    }

    protected void execute() {
    	PIDSubsystem.setSetpoint(200);
    	PIDSubsystem.enable();
    	
    	double value = PIDSubsystem.getPIDController().getError();
    	values.add(value);
    	
    	double time = timeSinceInitialized();
    	times.add(time);
    	
    	PIDSubsystem.printInfo();
    }

    protected boolean isFinished() {
    	return isTimedOut();
    }

    protected void end() {
    	log.info("done");
    	PIDSubsystem.setSetpoint(0);
    	
    	Double[] valuesArray = values.toArray(new Double[values.size()]);
    	Robot.table.putNumberArray("values", valuesArray);
    	
    	Double[] timesArray = times.toArray(new Double[times.size()]);
    	Robot.table.putNumberArray("times", timesArray);
		
    	PIDSubsystem.printPIDValues();
		
		log.info("" + PIDSubsystem.onTarget());
    }    	

    protected void interrupted() {

    }
}
