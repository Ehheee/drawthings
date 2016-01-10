package thething.drawthings;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String drawType;
	private DrawingCalculator calc;
	
	public DrawingPanel(String drawType, String[] args){
		this.drawType = drawType;
		this.calc = new DrawingCalculator(args);
		setBorder(BorderFactory.createLineBorder(Color.black));
		
	}
	public Dimension getPreferredSize() {
		return new Dimension(100, 100);
	}
	public void paintComponent(Graphics g) {
		calc.setSize(getSize());
		calc.paint(g, drawType);
	}
}
