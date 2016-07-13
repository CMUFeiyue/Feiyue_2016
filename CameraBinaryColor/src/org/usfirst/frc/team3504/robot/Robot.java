package org.usfirst.frc.team3504.robot;

import java.util.Comparator;
import java.util.Vector;
import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ImageType;
import com.ni.vision.NIVision.ShapeMode;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Example of finding images based on color.
 * This example utilizes camera output
 */

public class Robot extends SampleRobot {
	
	//A structure to hold measurements of a particle
	public class ParticleReport implements Comparator<ParticleReport>, Comparable<ParticleReport> {
		double PercentAreaToImageArea;
		double Area;
		double BoundingRectLeft;
		double BoundingRectTop;
		double BoundingRectRight;
		double BoundingRectBottom;

		public int compareTo(ParticleReport r) {
			return (int)(r.Area - this.Area);
		}

		public int compare(ParticleReport r1, ParticleReport r2) {
			return (int)(r1.Area - r2.Area);
		}
	}

	//Images
	Image frame;
	Image binaryFrame;
	Image mask;
	int imaqError;
	int session;

	//Constants

	//		NIVision.Range TOTE_HUE_RANGE = new NIVision.Range(24, 49);		//hue range for yellow tote
	//		NIVision.Range TOTE_SAT_RANGE = new NIVision.Range(67, 255);	//saturation range for yellow tote
	//		NIVision.Range TOTE_VAL_RANGE = new NIVision.Range(49, 255);	//value range for yellow tote

	NIVision.Range TOTE_HUE_RANGE = new NIVision.Range(100,255);	//red range for red tote
	NIVision.Range TOTE_SAT_RANGE = new NIVision.Range(0,80);		//green range for red tote
	NIVision.Range TOTE_VAL_RANGE = new NIVision.Range(0,80);		//blue range for red tote


	double AREA_MINIMUM = 0.5; //Default Area minimum for particle as a percentage of total image area
	double LONG_RATIO = 2.22; //Tote long side = 26.9 / Tote height = 12.1 = 2.22
	double SHORT_RATIO = 1.4; //Tote short side = 16.9 / Tote height = 12.1 = 1.4
	double SCORE_MIN = 75.0;  //Minimum score to be considered a tote
	double VIEW_ANGLE = 49.4; //View angle of camera, set to Axis m1011 by default, 64 for m1013, 51.7 for 206, 52 for HD3000 square, 60 for HD3000 640x480

	//set criteria for what is consodered a "large" particle
	NIVision.ParticleFilterCriteria2 criteria[] = new NIVision.ParticleFilterCriteria2[1];
	NIVision.ParticleFilterOptions2 filterOptions = new NIVision.ParticleFilterOptions2(0,0,1,1);

	public void robotInit() {
		// create images
		frame = NIVision.imaqCreateImage(ImageType.IMAGE_RGB, 0);
		//mask = NIVision.imaqCreateImage(ImageType.IMAGE_U8, 0);
		binaryFrame = NIVision.imaqCreateImage(ImageType.IMAGE_U8, 0);
		criteria[0] = new NIVision.ParticleFilterCriteria2(NIVision.MeasurementType.MT_AREA_BY_IMAGE_AREA, AREA_MINIMUM, 100.0, 0, 0);
		session = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController);

		NIVision.IMAQdxConfigureGrab(session);				
		NIVision.IMAQdxStartAcquisition(session);

		//Put default values to SmartDashboard so fields will appear
		SmartDashboard.putNumber("Tote hue min", TOTE_HUE_RANGE.minValue);
		SmartDashboard.putNumber("Tote hue max", TOTE_HUE_RANGE.maxValue);
		SmartDashboard.putNumber("Tote sat min", TOTE_SAT_RANGE.minValue);
		SmartDashboard.putNumber("Tote sat max", TOTE_SAT_RANGE.maxValue);
		SmartDashboard.putNumber("Tote val min", TOTE_VAL_RANGE.minValue);
		SmartDashboard.putNumber("Tote val max", TOTE_VAL_RANGE.maxValue);
		SmartDashboard.putNumber("Area min %", AREA_MINIMUM);	
	}

	public void autonomous(){ 
	}

	public void operatorControl() {
		while(isOperatorControl() && isEnabled()) {
			ParticleReport par = new ParticleReport();									
			NIVision.IMAQdxGrab(session, frame, 1);

			//Update threshold values from SmartDashboard. For performance reasons it is recommended to remove this after calibration is finished.
			TOTE_HUE_RANGE.minValue = (int)SmartDashboard.getNumber("Tote hue min", TOTE_HUE_RANGE.minValue);
			TOTE_HUE_RANGE.maxValue = (int)SmartDashboard.getNumber("Tote hue max", TOTE_HUE_RANGE.maxValue);
			TOTE_SAT_RANGE.minValue = (int)SmartDashboard.getNumber("Tote sat min", TOTE_SAT_RANGE.minValue);
			TOTE_SAT_RANGE.maxValue = (int)SmartDashboard.getNumber("Tote sat max", TOTE_SAT_RANGE.maxValue);
			TOTE_VAL_RANGE.minValue = (int)SmartDashboard.getNumber("Tote val min", TOTE_VAL_RANGE.minValue);
			TOTE_VAL_RANGE.maxValue = (int)SmartDashboard.getNumber("Tote val max", TOTE_VAL_RANGE.maxValue);

			NIVision.imaqColorThreshold(binaryFrame, frame, 255, 
					NIVision.ColorMode.RGB, TOTE_HUE_RANGE, TOTE_SAT_RANGE, TOTE_VAL_RANGE);	//for RED
			//NIVision.ColorMode.HSV, TOTE_HUE_RANGE, TOTE_SAT_RANGE, TOTE_VAL_RANGE);		//for Yellow		

			//Send particle count to dashboard
			int numParticles = NIVision.imaqCountParticles(binaryFrame, 1);
			SmartDashboard.putNumber("Masked particles", numParticles);

			//Send masked image to dashboard to assist in tweaking mask.
			int numParticlesBefore = NIVision.imaqCountParticles(binaryFrame, 1);

			//filter out small particles
			float areaMin = (float)SmartDashboard.getNumber("Area min %", AREA_MINIMUM);
			criteria[0].lower = areaMin;			
			imaqError = NIVision.imaqParticleFilter4(binaryFrame, binaryFrame, criteria, filterOptions, null);

			//Send particle count after filtering to dashboard
			numParticles = NIVision.imaqCountParticles(binaryFrame, 1);
			SmartDashboard.putNumber("Filtered particles", numParticles);

			//print out number of particles in Riolog
			System.out.println("number of particles before: " + numParticlesBefore);
			System.out.println("number of particles after: " + numParticles);

			if(numParticles > 0){
				//Measure particles and sort by particle size
				Vector<ParticleReport> particles = new Vector<ParticleReport>();
				for(int particleIndex = 0; particleIndex < numParticles; particleIndex++){
					par.PercentAreaToImageArea = NIVision.imaqMeasureParticle(binaryFrame, particleIndex, 0, NIVision.MeasurementType.MT_AREA_BY_IMAGE_AREA);
					par.Area = NIVision.imaqMeasureParticle(binaryFrame, particleIndex, 0, NIVision.MeasurementType.MT_AREA);
					par.BoundingRectTop = NIVision.imaqMeasureParticle(binaryFrame, particleIndex, 0, NIVision.MeasurementType.MT_BOUNDING_RECT_TOP);
					par.BoundingRectLeft = NIVision.imaqMeasureParticle(binaryFrame, particleIndex, 0, NIVision.MeasurementType.MT_BOUNDING_RECT_LEFT);
					par.BoundingRectBottom = NIVision.imaqMeasureParticle(binaryFrame, particleIndex, 0, NIVision.MeasurementType.MT_BOUNDING_RECT_BOTTOM);
					par.BoundingRectRight = NIVision.imaqMeasureParticle(binaryFrame, particleIndex, 0, NIVision.MeasurementType.MT_BOUNDING_RECT_RIGHT);
					particles.add(par);
				}	

				//print out location of top, botton, left, and right of largest particle
				System.out.println("bound rect top:" + par.BoundingRectTop);
				System.out.println("bound rect left:" + par.BoundingRectLeft);
				System.out.println("bound rect bottom:" + par.BoundingRectBottom);
				System.out.println("bound rect right:" + par.BoundingRectRight);

				double y = par.BoundingRectTop;
				double x = par.BoundingRectLeft;
				double h = par.BoundingRectBottom - par.BoundingRectTop;
				double w = par.BoundingRectRight - par.BoundingRectLeft;

				System.out.println("x: " + x + " y: " + y + " h: " + h + " w: " + w);
				System.out.println("BB: "+par.BoundingRectBottom+" BT: "+par.BoundingRectTop);


				//draw rectangle around largest particle
				NIVision.Rect rect = new NIVision.Rect((int)y,(int)x,(int)h,(int)w); //(0,0) is top left
				NIVision.imaqDrawShapeOnImage(frame, frame, rect,
						DrawMode.DRAW_VALUE, ShapeMode.SHAPE_RECT, 0.0f);		

				//show image w/ rectangle on dashboard
				CameraServer.getInstance().setImage(frame);

				particles.sort(null);
			} 
			
			else {
			}

			Timer.delay(0.005);	// wait for a motor update time
		}
	}

	//Comparator function for sorting particles. Returns true if particle 1 is larger
	static boolean CompareParticleSizes(ParticleReport particle1, ParticleReport particle2) {
		//we want descending sort order
		return particle1.PercentAreaToImageArea > particle2.PercentAreaToImageArea;
	}


}
