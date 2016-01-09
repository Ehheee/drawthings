package thething.drawthings;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel{
	
	DrawingCalculator calc;
	public DrawingPanel(){
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		
	}
	public Dimension getPreferredSize() {
		return new Dimension(512, 512);
	}
	public void paintComponent(Graphics g) {
		calc = new DrawingCalculator(this.getSize());
		calc.paint(g);
	}
}
