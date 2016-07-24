package org.usfirst.frc.team3504.robot.commands;

import java.util.ArrayList;

import org.usfirst.frc.team3504.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class TunePID extends Command {

	private ArrayList<Double> values;
	private ArrayList<Double> times;
	
	public TunePID () {
    	this.requires(Robot.driveTrain);
    }

    protected void initialize() {
    	System.out.println("init");
    	values = new ArrayList<Double>();
    	times = new ArrayList<Double>();
    	
    	Robot.driveTrain.updatePIDValues();

    	//double timeout = table.getNumber("timeout", 0);

    	double timeout = 5;
    	this.setTimeout(timeout);
    	System.out.println("running");
    }

    protected void execute() {
    	Robot.driveTrain.setSetpoint(0.5);
    	Robot.driveTrain.enable();
    	
    	/*
    	double value = Robot.driveTrain.getPIDController().getError();
    	values.add(value);
    	
    	double time = timeSinceInitialized();
    	times.add(time);
    	*/
    	
    	Robot.driveTrain.printInfo();
    }

    protected boolean isFinished() {
    	return isTimedOut();
    }

    protected void end() {
    	System.out.println("done");
    	Robot.driveTrain.setSetpoint(0.0);
    
    	/*
    	Double[] valuesArray = values.toArray(new Double[values.size()]);
    	Robot.table.putNumberArray("values", valuesArray);
    	
    	Double[] timesArray = times.toArray(new Double[times.size()]);
    	Robot.table.putNumberArray("times", timesArray);
		*/
    	
    	Robot.driveTrain.printPIDValues();
		
		System.out.println(Robot.driveTrain.onTarget());
    }    	

    protected void interrupted() {

    }
}
