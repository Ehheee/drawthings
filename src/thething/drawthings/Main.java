package thething.drawthings;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import thething.drawthings.noise.SimpleNoise;

public class Main {

	
	public static void main(final String[] args) {
		System.out.println(args);
		final String drawType;
		if (args.length < 1) {
			drawType = "circle";
		} else {
			drawType = args[0];
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(drawType, args);   
			} 
		});

	}
	private static void createAndShowGUI(String drawType, String[] args) {
		JFrame f = new JFrame("Swing Paint Demo");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000,1000);
		f.add(new DrawingPanel(drawType, args));
		f.pack();
		f.setVisible(true);
	}
}
