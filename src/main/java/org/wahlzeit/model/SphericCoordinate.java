package org.wahlzeit.model;

import org.junit.Assert;

@Pattern(
		name = "Template", 
		participants = { "ConcreteClass" }
		)

public class SphericCoordinate extends AbstractCoordinate {
	
	private double latitude = 0;
	private double longtitude = 0;
	private double radius = RADIUS;
	
	public SphericCoordinate(double latitude, double longtitude) {
		
		assertClassInvariants();
		
		this.latitude = latitude;
		this.longtitude = longtitude;
	}
	
	public void assertClassInvariants() {
		// TODO Auto-generated method stub
		assert radius != 0;	
		assert latitude <= 90;
		assert longtitude <= 180;
	}


	public double getDistance(Coordinate co) {
		// TODO Auto-generated method stub
		
		assert co != null;
		
		double c1, c2, result;
		if (co instanceof SphericCoordinate) {
			c1 = ((SphericCoordinate) co).latitude;
			c2 = ((SphericCoordinate) co).longtitude;
			result = radius * 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(Math.abs(latitude - c1) / 2), 2)
					+ Math.cos(longtitude) * Math.cos(c2) * Math.pow(Math.sin(Math.abs(longtitude - c2) / 2), 2)));
			Assert.assertTrue("sDistance Error!", result >= 0);
			return result;
		}else return 0;		
	}

	public boolean isEqual(Coordinate co) {
		// TODO Auto-generated method stub
		
		assert co != null;
		
		if (((SphericCoordinate) co).latitude == latitude && ((SphericCoordinate) co).longtitude == longtitude) {
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
		
		CartesianCoordinate cc = new CartesianCoordinate(x, y, z);
		Assert.assertTrue("sTransformation Error!", cc != null);
		return cc;
	}

}
