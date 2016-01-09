package thething.drawthings.noise;

public class NoiseFunctions {

	
	public double simpleNoise(int x, int y, SimpleNoise simpleNoise){
		return simpleNoise.getNoise(x, y);
	}
	
	public double fractalNoise(double x, double y, SimpleNoise simpleNoise,double startFreq,double levels){
		double fractalNoise = 0;
		double amplitude = 1;
		double freq = startFreq;
		double maxSum = 0;
		for(int i = 0; i<levels; i++){
			maxSum += amplitude;
			fractalNoise += simpleNoise.getNoise(x*freq,y*freq)*amplitude;
			amplitude *= 0.5;
			freq *= 2;
		}
		fractalNoise = fractalNoise/maxSum;		
		return fractalNoise;
	}
	
	public double turbulentNoise(int x, int y, SimpleNoise simpleNoise){
		return Math.abs(turnToSigned(fractalNoise(x, y, simpleNoise, 1, 7)));
	}
	
	public double turbulentNoise2(int x, int y, SimpleNoise simpleNoise){
		return Math.abs(signedNoise(x, y, simpleNoise));
	}
	
	private double turnToSigned(double noise){
		return (2 * noise -1);
	}
	
	public double signedNoise(double x, double y, SimpleNoise simpleNoise){
		return (2 * simpleNoise.getNoise(x, y) -1);
	}
	
	public double marbleNoise(int x, int y, SimpleNoise simpleNoise){
		return ( Math.sin( x * 1024+ this.fractalNoise(x*0.5, y*0.5, simpleNoise, 0.5, 5) * 16) + 1 ) * 0.5;
	}
}
