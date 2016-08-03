package tuner;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class PIDGraph extends ApplicationFrame {
	private static final long serialVersionUID = 1L;
	
	public static NetworkTable table; 
	public static DefaultCategoryDataset toGraph;
	public static String path;
	public static String graphTitle;
	public static String xLable;
	public static String yLable;

	public static void main( String[ ] args ) throws IOException {
		NetworkTable.setClientMode();
		NetworkTable.setIPAddress("roborio-9999-frc.local");
		table = NetworkTable.getTable("PID");
		
		Scanner br = new Scanner(System.in); 
		path = "C:\\Users\\Girls of Steel\\";
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
				String fileName = br.next();
				toGraph = createDataset();
				saveGraph(fileName);
			}
		}
	}
	
	public PIDGraph() {
	    super(graphTitle);

	    JFreeChart graph = createGraph();
		
		ChartPanel chartPanel = new ChartPanel(graph);
		chartPanel.setPreferredSize( new java.awt.Dimension(560, 367));
		setContentPane(chartPanel);
	}
	
	public static JFreeChart createGraph() {
		JFreeChart graph = ChartFactory.createLineChart(
				graphTitle, xLable,
				yLable,
				toGraph, 
				PlotOrientation.VERTICAL,
				true,true,false);
		return graph;
	}
	
	public static void displayGraph() {		
		PIDGraph graph = new PIDGraph();
		
		graph.pack( );
		RefineryUtilities.centerFrameOnScreen(graph);
		graph.setVisible( true );
	}
	
	public static void saveGraph(String fileName) throws IOException {	
	    JFreeChart graph = createGraph();

		int width = 640; /* Width of the image */
		int height = 480; /* Height of the image */ 
		File chartPath = new File(path + fileName + ".jpeg"); 
		ChartUtilities.saveChartAsJPEG(chartPath, graph, width ,height);
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
}
