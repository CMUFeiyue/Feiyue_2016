package org.usfirst.frc.team9999.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
		public static final int JOYSTICK_PORT =2;
		public static final int MOTOR_PORT =1;
		
		public static final int MASTER_LEFT=1;
		public static final int SLAVE_LEFT=2;
		public static final int MASTER_RIGHT=11;
		public static final int SLAVE_RIGHT=12;
		private static final double pulsePerRevolution=360;
		private static final double gearRatio = (1/27.21);
		private static final double wheelSize=8.0;
		private static final double distPerRevolution = wheelSize * Math.PI * gearRatio;
		public static final double DIST_PER_PULSE = distPerRevolution/pulsePerRevolution;
		public static final int LIMITSWITCH_PORT = 0;
		
		public static final int SOLENOID_FWD_CHANNEL = 0;
		public static final int SOLENOID_BWD_CHANNEL = 1;
		/*public enum Camera{
			MYCAMERA("cam0");
			public static final int INVALID_CAM = -1;
			protected final String systemName;
			protected int streamDescriptor;
			Camera(String systemName){
				
			}
			}*/
}


