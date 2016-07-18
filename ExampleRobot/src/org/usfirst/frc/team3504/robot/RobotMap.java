package org.usfirst.frc.team3504.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int DRIVE_MASTER = 1;
	public static final int DRIVE_SLAVE = 3;
	
	public static final int JOYSTICK_PORT = 0;
	
	public static final String[] CAMERA_NAMES = {"cam0"};
	// Encoder-to-distance constants
		// How many ticks are there on the encoder wheel?
		private static final double pulsePerRevolution = 360;
		// How far to we travel when the encoder turns one full revolution?
		// Gear ratio is turns of the wheel per turns of the encoder
		private static final double distancePerRevolutionHighGear = 8.0/*wheel size*/ * Math.PI * (1/27.21)/*gear ratio*/; //(9.07)
		private static final double distancePerRevolutionLowGear = 8.0/*wheel size*/ * Math.PI * (1/28.33)/*gear ratio*/; //28.33/15.9 (33.33) 
	    // Given our set of wheels and gear box, how many inches do we travel per pulse?
		public static final double DISTANCE_PER_PULSE_HIGH_GEAR = distancePerRevolutionHighGear / pulsePerRevolution;
		public static final double DISTANCE_PER_PULSE_LOW_GEAR = distancePerRevolutionLowGear / pulsePerRevolution;


}
