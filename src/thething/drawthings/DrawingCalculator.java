package thething.drawthings;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import thething.drawthings.noise.NoiseFunctions;
import thething.drawthings.noise.SimpleNoise;

public class DrawingCalculator {

	BufferedImage canvas;
	
	public DrawingCalculator(Dimension size){
		canvas = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
		
	}
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		
		
		int maxY = canvas.getHeight();
		int maxX = canvas.getWidth();
		for(int x = 0; x < maxX;x++){
			for(int y = 0; y < maxY;y++){
				Color color = getColorForPoint2(x, y);
				
				canvas.setRGB(x, y, color.getRGB());
			}
		}
		
		//paintNoise();
		g2.drawImage(canvas, null, null);
		
		//g2.drawString("it works", 10, 20);
	}
	
	private void paintNoise(){
		NoiseFunctions noiseFuncs = new NoiseFunctions();
		int maxY = canvas.getHeight();
		int maxX = canvas.getWidth();
		SimpleNoise simpleNoise = new SimpleNoise(256, maxY, maxX);
		for(int x = 0; x < maxX; x++){
			for(int y = 0; y < maxY; y++){
				//double noise = noiseFuncs.simpleNoise(x*10, y*10, simpleNoise);
				//double noise = noiseFuncs.fractalNoise(x, y, simpleNoise, 1, 7);
				double noise = noiseFuncs.marbleNoise(x, y, simpleNoise);
				int color = (int)(noise * 255);
				canvas.setRGB(x, y, new Color(color, color, color).getRGB());
			}
		}
	}
	

	
	
	

	
	public Color getColorForPoint2(int x, int y){
		Float smallX = (float) x / 10f;											//Controlles the size of the circles. The larger the divider, the smaller the circles
		Float smallY = (float) y / 10f;
		Color color = new Color(255, 255, 255);									//Sets the default color(white), which is only changed if the point is in the circle
		float radius = 3f;														//Sets the radius of the circle
		float spacing = 1f;														//How far apart the circles are
		double linewidth = 8;													//How fat the line of a single circle is
		float d = 2 * radius + spacing;											//Calculates the size of squares containing the circles
		//System.out.println("d: " + d);
		float sy = (float) Math.floor(smallY / d);								//Calculates which circle/square the given point belongs to
		float sx = (float) Math.floor(smallX / d);
		//System.out.println("sX: " + sx + " sY: " + sy);
		float h = sx *d + radius + spacing/2;									//Calculates the center point of the circle that should be used to checked against.
		float k = sy *d + radius + spacing/2;
		float res = (smallX - h)*(smallX - h) + (smallY - k)*(smallY - k);		//Calculates the square radius that the circle that contains the given points would have
		//System.out.println("h: " + h + " k: " + k);
		//System.out.println("X: " + smallX + " Y: " + smallY + " res: " + res);
		if(Math.abs(res - radius*radius) < linewidth){							//if the theoretical circle calculated in previous point falls into the correct circle with linewidth also considered
			Random rand = new Random();
			//Below code causes fat circle lines to be a bit more smoother. Also added a random element just for testing and fun
			double fraction = 255 / linewidth;									
			int c = (int) (fraction * (Math.abs(res - radius*radius)));
			System.out.println(c);
			color = new Color((int) (c*rand.nextDouble()), (int) (c*rand.nextDouble()), (int) (c*rand.nextDouble()));
			
		}
		return color;
	}
	
	public Color getColorForPoint1(int x, int y){
		Float smallX = (float) x / 20f;
		Float smallY = (float) y / 20f;
		Color color = new Color(255, 255, 255);
		if( smallX % 1.5 < 1.4 && smallX % 1.5 > 0.6){
			
			if(Math.abs((smallX % 1.5) - (smallY %1.5)) < 0.4 || Math.abs((smallY % 1.5) - (smallX %1.5)) < 0.4){
				Float lum = (float) ((smallX % 1.5) * 125);
				int c = lum.intValue();
				color = new Color(c, c, c);
				//System.out.println((smallX % 1.5) - (smallY % 1.5));
				//System.out.println("x: " + x + " y: " + y + " color: " + color);
			}
		}
		
		return color;
	}
}
