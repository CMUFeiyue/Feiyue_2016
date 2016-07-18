package org.usfirst.frc.team3504.robot;

public class RobotMap {

	//TODO: Fix ports for motors
	public static final int MASTER_LEFT = 1;
	public static final int SLAVE_LEFT = 1;
	
	public static final int MASTER_RIGHT= 3;
	public static final int SLAVE_RIGHT= 3;
	
	public static final int JOYSTICK_PORT = 0;
	
	// List of cameras on the robot
	public static final String[] CAMERA_NAMES = {"cam0"};
	
	// Encoder-to-distance constants
	// How many ticks are there on the encoder wheel?
	private static final double pulsePerRevolution = 360;

	// How far to we travel when the encoder turns one full revolution?
	// Gear ratio is turns of the wheel per turns of the encoder
	private static final double wheelSize = 8.0;
	private static final double highGearRatio = (1/27.21);
	private static final double lowGearRatio = (1/28.33);
	
	private static final double distPerRevolutionHighGear = 
			wheelSize * Math.PI * highGearRatio; //(9.07)
	private static final double distPerRevolutionLowGear = 
			wheelSize * Math.PI * lowGearRatio; //28.33/15.9 (33.33) 
    
	// Given our set of wheels and gear box, how many inches do we travel per pulse?
	public static final double DIST_PER_PULSE_HIGH_GEAR = 
			distPerRevolutionHighGear / pulsePerRevolution;
	public static final double DIST_PER_PULSE_LOW_GEAR = 
			distPerRevolutionLowGear / pulsePerRevolution;


}
