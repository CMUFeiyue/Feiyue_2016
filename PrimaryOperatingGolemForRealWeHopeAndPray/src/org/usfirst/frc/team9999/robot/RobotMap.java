package org.usfirst.frc.team9999.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static final int JOYSTICK_PORT_A = 0;
	
	public static final int SOLENOID_FWD_CHANNEL = 0;
	public static final int SOLENOID_BWD_CHANNEL = 1;
	// How many ticks are there on the encoder wheel?
		private static final double pulsePerRevolution = 360;

		// How far to we travel when the encoder turns one full revolution?
		// Gear ratio is turns of the wheel per turns of the encoder
		private static final double wheelSize = 8.0;
		private static final double gearRatio = (1/27.21);
			
		private static final double distPerRevolution = 
				wheelSize * Math.PI * gearRatio; //(9.07)
		
		// Given our set of wheels and gear box, how many inches do we travel per pulse?
		public static final double DIST_PER_PULSE = 
				distPerRevolution / pulsePerRevolution;
		
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
