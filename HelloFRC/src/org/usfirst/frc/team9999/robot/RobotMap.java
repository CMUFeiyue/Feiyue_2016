package org.usfirst.frc.team9999.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int JOYSTICK_PORT = 1
					,PAD_PORT = 0
					
					,MOTORR_PORT = 1
					,SLAVER_PORT = 2
					,MOTORL_PORT = 3
					,SLAVEL_PORT = 4
					,LIMIT_SWITCH = 6 

					,SOLENOIDL_FWD = 1
					,SOLENOIDL_BWD = 0
					,SOLENOIDR_FWD = 2
					,SOLENOIDR_BWD = 3
					,PUSHER_SOLENOID_FWD = 4
					,PUSHER_SOLENOID_BWD = 5
					
					,SPINNER_L_PORT = 5
					,SPINNER_R_PORT = 0;
	
	public enum Camera{
		
		SHOOTER_CAM("cam0"),
		
		FORWARD_CAM("cam1");
		
		protected final String systemName;
		
		public static final int INVALID_CAM = -1;

		protected int streamDescriptor;
		
		Camera(String systemName){
			this.systemName = systemName;
			this.streamDescriptor = INVALID_CAM;
		}
		
		public String getSysName(){
			return systemName;
		}
		
		public void setStreamDescriptor(int descripor){
			this.streamDescriptor = descripor;
		}
		
		public int getStreamDescriptor(){
			return this.streamDescriptor;
		}
	}
}
