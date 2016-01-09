package thething.drawthings.noise;

import java.util.Random;
import thething.drawthings.common.UtilFunctions;

public class SimpleNoise {

	private float[] randoms;
	private int randomsSize, randomsMask;
	private double invImageHeight, invImageWidth;
	
	
	public SimpleNoise(int randomsSize, int imageHeight, int imageWidth){
		this.randomsSize = randomsSize;
		this.randomsMask = randomsSize -1;
		randoms = new float[randomsSize*randomsSize];
		invImageHeight = 1.0/imageHeight;
		invImageWidth = 1.0/imageWidth;
		this.generateRandoms();
	}
	
	private void generateRandoms(){
		Random random = new Random(152L);
		for(int i = 0; i < randomsSize*randomsSize; i++){
			randoms[i] = random.nextFloat();
		}
	}
	

	public double getNoise(double x, double y){
		double newX = x*invImageWidth*10;
		double newY = y*invImageHeight*10;
		return evaluateNoise(newX, newY);
		
	}
	
	private double evaluateNoise(double  x, double y){
		int xi = (int) Math.floor(x);
		int yi = (int) Math.floor(y);
		double tx = x - xi;
		double ty = y - yi;
		int rx0 =  xi & randomsMask;
		int rx1 =(rx0 + 1) & randomsMask;
		int ry0 = yi & randomsMask;
		int ry1 = (ry0 + 1) & randomsMask;
		
		double c00 = randoms[ ry0 * randomsMask + rx0 ];
		double c10 = randoms[ ry0 * randomsMask + rx1 ];
		double c01 = randoms[ ry1 * randomsMask + rx0 ];
		double c11 = randoms[ ry1 * randomsMask + rx1 ];
		
		
		double sx = UtilFunctions.smoothStep(tx);
		double sy = UtilFunctions.smoothStep(ty);
		
		double nx0 = UtilFunctions.lerp(c00, c10, sx);
		double nx1 = UtilFunctions.lerp(c01, c11, sx);
		
		return UtilFunctions.lerp(nx0, nx1, sy);
	}


	
	
	
}
