package com.ait.calc.model;

public class PlotPoint{
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}

	private Double x,y;
	public PlotPoint(Double x,Double y){
		this.x=x;
		this.y=y;
	}
}
