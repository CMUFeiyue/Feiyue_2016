package examplePackage;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.opencv.core.Mat;
import org.opencv.core.Core;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
/**
 * Example reference class to test the setup of github,
 * demonstate typical class structure, and provide an
 * example of Javadoc documentation.
 * @author Val Kozina
 */

public class ExampleClass {
	public final static Logger log = Logger.getLogger(ExampleClass.class.getName());
	/**
	 * Example types and class variables
	 */
	private static int myInt;
	
	/**
	 * Example main function
	 * @param args
	 */
	public static void main(String[] args) {
		log.setLevel(Level.ALL);
		log.info("Camera init");

		/*
		VideoCapture cam = new VideoCapture(2);
		
		log.info("Attempting to open camera");
		while(!cam.isOpened()) {
			cam.open(2);
		}
		*/
		
		log.info("Camera opened");
		
//	/	cam.set(CV_CAP_PROP_EXPOSURE_ABSOLUTE, 0.1);
		
		Mat frame = new Mat();
		String path = ("C:\\Users\\Girls of Steel\\Pictures\\Camera Roll\\WIN_20160110_22_38_52_Pro.jpg");
		frame = Imgcodecs.imread(path);
		//cam.read(frame);
		log.info("Read frame");
		
		Highgui.imwrite("//Desktop//camera.jpg", frame);
		log.info("Done");
	}
	
	/**
	 * Example getter function
	 * @return The integer value stored by this class
	 */
	public static int getMyInt() {
		return myInt;
	}
	
	/**
	 * Example setter function
	 * @param newInt The new integer value that needs to be stored
	 */
	public static void setMyInt(int newInt) {
		myInt = newInt;
	}
	
	
	

}
