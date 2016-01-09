package thething.drawthings.common;

public class UtilFunctions {

	
	public static double smoothStep(double t){
		return t*t*(3-2*t);
	}
	
	public static double smootherStep(double t){
		return t*t*t*(t*(t*6 - 15) + 10);
	}
	
	public static double lerp(double a, double b, double t){
		return a * ( 1 - t ) + b * t;
	}
}
