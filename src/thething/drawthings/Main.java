package thething.drawthings;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import thething.drawthings.noise.SimpleNoise;

public class Main {

	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();   
			} 
		});

	}
	
	
	 
	 
	
	private static void createAndShowGUI() {
		System.out.println("Created GUI on EDT? "+
				SwingUtilities.isEventDispatchThread());
		JFrame f = new JFrame("Swing Paint Demo");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000,1000);
		
		f.add(new DrawingPanel());
		f.pack();
		f.setVisible(true);
	    }
}
