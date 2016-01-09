package thething.drawthings;

import java.awt.Point;

public class MyPoint {

	private Point point;
	private int[] color;
	
	public MyPoint(){
		
	}
	public MyPoint(Point point, int[] color) {
		super();
		this.point = point;
		this.color = color;
	}
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	public int[] getColor() {
		return color;
	}
	public void setColor(int[] color) {
		this.color = color;
	}
	
	public int getRed(){
		return this.color[0];
	}
	public void setRed(int r){
		this.color[0] = r;
	}
	public int getGreen(){
		return this.color[1];
	}
	public void setGreen(int g){
		this.color[1] = g;
	}
	public int getBlue(){
		return this.color[2];
	}
	public void setBlue(int b){
		this.color[2] = b;
	}
}
