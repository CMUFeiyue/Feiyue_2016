package org.usfirst.frc.team3504.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int MOTOR = 1;
	public static final double WHEEL_DIAMETER = 8.0;
	private static final double pulsePerRevolution = 360;
	public static final double DISTANCE_PER_PULSE = (WHEEL_DIAMETER * Math.PI) / pulsePerRevolution; 
}
