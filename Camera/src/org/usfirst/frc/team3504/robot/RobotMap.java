package org.usfirst.frc.team3504.robot;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RobotMap {

	public final static Logger log = Logger.getLogger(RobotMap.class.getName());
	
	public RobotMap() {
		log.setLevel(Level.ALL);
	}
	
	public enum Camera {
		//Enum: camera nickname, Value: roboRIO provided camera ID (or system name)
		//For example, MY_CAMERA("cam0");
		MY_CAMERA("cam0");
		
		public static final int INVALID_CAM = -1;
		protected final String systemName;
		protected int streamDescriptor;
		
    	Camera(String systemName) {	
    		this.systemName = systemName;
    		this.streamDescriptor = INVALID_CAM;
    	}
    	
    	public String systemName()	{
    		return systemName;	
    	}
    	
    	public void setStreamID(int streamNum) {
    		this.streamDescriptor = streamNum;
    	}
    	
    	public int getStreamID() {
    		return streamDescriptor;
    	}
	}
}