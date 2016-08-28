package tuner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Renderer extends JFrame implements ActionListener  {
	protected JButton b1, b2, b3;

	public Renderer() {
		 b1 = new JButton("Disable middle button");
		 b1.setVerticalTextPosition(AbstractButton.CENTER);
		 b1.setHorizontalTextPosition(AbstractButton.LEADING);
		 b1.setMnemonic(KeyEvent.VK_D);
		 b1.setActionCommand("disable");
		 
		 b1.addActionListener(this);
	 
	     b1.setToolTipText("Click this button to disable the middle button.");
	 
	     //Add Components to this container, using the default FlowLayout.
	     add(b1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 b1.setEnabled(true);
		
	}
	
	private static void createAndShowGUI() {
		  
	        //Create and set up the window.
	        JFrame frame = new JFrame("ButtonDemo");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        //Create and set up the content pane.
	        Renderer newContentPane = new Renderer();
	        newContentPane.setOpaque(true); //content panes must be opaque
	        frame.setContentPane(newContentPane);
	 
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
	
	public static void main(String[] args) {
	        //Schedule a job for the event-dispatching thread:
	        //creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(); 
	            }
	        });
	    }
}
