package tuner;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Tuner {

	public static void main(String[] args) {
		new Tuner().run();
	}
	
	public void run() {
		
		NetworkTable.setClientMode();
		NetworkTable.setIPAddress("roborio-3504-frc.local");
		NetworkTable table = NetworkTable.getTable("PID");
		
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				System.out.println(ex);
			}
			
			
			double[] temp = {0};
			double[] values = table.getNumberArray("values", temp);
			double[] times = table.getNumberArray("times", temp);
			
			for(double value : values) {
				System.out.println(value);
			}
			
			System.out.println("next");
			
			System.out.println(table.getNumber("error", 0));
			//System.out.println(times);
		}
	}
}
