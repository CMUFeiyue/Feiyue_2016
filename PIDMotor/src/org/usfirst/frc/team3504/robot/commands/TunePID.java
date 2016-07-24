package org.usfirst.frc.team3504.robot.commands;

import java.util.ArrayList;

import org.usfirst.frc.team3504.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class TunePID extends Command {

	private ArrayList<Double> values;
	private ArrayList<Double> times;
	NetworkTable table = NetworkTable.getTable("datatable");
	
    public TunePID () {
    	this.requires(Robot.driveMotor);
    }

    protected void initialize() {
    	System.out.println("tne init");
    	values = new ArrayList<Double>();
    	times = new ArrayList<Double>();
    	
    	//Robot.driveMotor.updatePIDValues();
    	
    	//double timeout = table.getNumber("timeout", 0);
    	double timeout = 5.0;
    	this.setTimeout(timeout);
    }

    protected void execute() {
    	System.out.println("running");
    	Robot.driveMotor.forward();
    	
    	double value = Robot.driveMotor.getPlotValue();
    	values.add(value);
    	
    	double time = timeSinceInitialized();
    	times.add(time);
    }

    protected boolean isFinished() {
    	return false;
    /*
    	if(isTimedOut()) {
    		System.out.println("done");
    		return true;
    	}
    	else
    		return false;
    		*/
        //return isTimedOut();
    }

    protected void end() {
    	Robot.driveMotor.stop();
    	Double[] valuesArray = values.toArray(new Double[values.size()]);
    	table.putNumberArray("values", valuesArray);
    	
    	Double[] timesArray = times.toArray(new Double[times.size()]);
    	table.putNumberArray("times", timesArray);
    }

    protected void interrupted() {

    }
}
