package org.wahlzeit.model;


public class SphericCoordinate extends AbstractCoordinate {
	
	private double latitude = 0;
	private double longtitude = 0;
	private double radius = RADIUS;
	
	public SphericCoordinate(double latitude, double longtitude) {
		this.latitude = latitude;
		this.longtitude = longtitude;
	}
	
	

	public double getDistance(Coordinate co) {
		// TODO Auto-generated method stub
		double c1, c2;
		if (co instanceof SphericCoordinate) {
			c1 = ((SphericCoordinate) co).latitude;
			c2 = ((SphericCoordinate) co).longtitude;
			return radius * 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(Math.abs(latitude - c1) / 2), 2)
					+ Math.cos(longtitude) * Math.cos(c2) * Math.pow(Math.sin(Math.abs(longtitude - c2) / 2), 2)));
		}else return 0;
	}

	public boolean isEqual(Coordinate co) {
		// TODO Auto-generated method stub
		if (co.equals(this)) {
			return true;
		}else return false;
	}

	public Coordinate toSphericCoordinate() {
		// TODO Auto-generated method stub
		return this;
	}

	public Coordinate toCartesianCoordinate() {
		// TODO Auto-generated method stub
		double x, y, z;
		x = 2 * radius * Math.cos(latitude) * Math.cos(longtitude);
		y = 2 * radius * Math.cos(latitude) * Math.sin(longtitude);
		z = 2 * radius * Math.sin(latitude);
		return new CartesianCoordinate(x, y, z);
	}

	
}
