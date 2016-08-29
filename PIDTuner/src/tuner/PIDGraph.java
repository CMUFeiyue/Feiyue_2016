package tuner;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
//import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import javax.swing.*;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class PIDGraph {
	private static final long serialVersionUID = 1L;
	
	public static NetworkTable table; 
	public static DefaultCategoryDataset toGraph;
	public static JFileChooser fc;
	public static String path = "";
	public static String graphTitle;
	public static String xLable;
	public static String yLable;
	public static JFreeChart graph;
	public static GraphDisplay graphDisplay;

	public static void main( String[ ] args ) throws IOException {
	//	NetworkTable.setClientMode();
		//NetworkTable.setIPAddress("roborio-9999-frc.local");
	//	table = NetworkTable.getTable("PID");
		
		fc = new JFileChooser();
		fc.setPreferredSize(new Dimension(1000, 500));
		Font font = new Font("Courier New", Font.PLAIN, 20);
		setFileChooserFont(fc.getComponents(), font);	    

		Scanner br = new Scanner(System.in); 
		
		graphDisplay = new GraphDisplay();
	
		graphTitle = "Error vs Time";
		xLable = "Time";
		yLable = "Error";
		
		while (true) {
			System.out.println("waiting for input");
			String input = br.next();
		
			if(input.equals("g")) {
				System.out.println("trying to graph");
				toGraph = createDataset();
				displayGraph();
			}
			
			if(input.equals("s")) {		
				System.out.println("trying to save, enter file name");
				saveGraph();
			}
		}
	}

	
	public static void createGraph() {
		graphDisplay.setTitle(graphTitle);			
	    graph = ChartFactory.createLineChart(
				graphTitle, xLable,
				yLable,
				toGraph, 
				PlotOrientation.VERTICAL,
				true,true,false);
		
		ChartPanel chartPanel = new ChartPanel(graph);
		chartPanel.setPreferredSize( new java.awt.Dimension(560, 367));
		graphDisplay.setContentPane(chartPanel);
	}
	
	public static void displayGraph() {		
	//	PIDGraph toGraph = new PIDGraph();
		createGraph();
		
		graphDisplay.pack( );
		RefineryUtilities.centerFrameOnScreen(graphDisplay);
		graphDisplay.setVisible( true );
	}
	
	public static void saveGraph() throws IOException {	
		PIDGraph toGraph = new PIDGraph();
		
		fc.setCurrentDirectory(new java.io.File(path));
		int returnVal = fc.showSaveDialog(toGraph);

		if(returnVal == JFileChooser.APPROVE_OPTION) {
			path = fc.getSelectedFile().getAbsolutePath();
		}

		int width = 640; /* Width of the image */
		int height = 480; /* Height of the image */ 
		File chartPath = new File(path + ".jpeg"); 
		ChartUtilities.saveChartAsJPEG(chartPath, toGraph.graph, width ,height);
	}
	
	public static DefaultCategoryDataset createDataset() {	
		double[] tempArray = {0};
		double[] values = table.getNumberArray("values", tempArray);
		double[] times = table.getNumberArray("times", tempArray);
		
		double temp = 0;
		double kP = table.getNumber("kP", temp);
		double kD = table.getNumber("kD", temp);
		double kI = table.getNumber("kI", temp);
		double f = table.getNumber("f", temp);
		String PIDInfo = ("kP: " + kP + ", kD: " + kD + ", kI: " + kI + ", f: " + f);
		

		DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
		for(int i = 0; i < times.length; i++ ) {
			double time = times[i];
			double value = values[i];
			dataset.addValue( value , PIDInfo , time + "" );
		}
		
		return dataset;
	}
	
	public static void runMotor() {
		double pVal, iVal, dVal;
		table.putNumber("kP", pVal);
	}
}
