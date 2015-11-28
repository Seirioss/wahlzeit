package org.wahlzeit.model;

import javax.security.auth.PrivateCredentialPermission;

import org.junit.Assert;

@Pattern(
		name = "Template Method", 
		participants = { "ConcreteClass" })

public class CartesianCoordinate extends AbstractCoordinate{
	
	private double x;
	private double y;
	private double z;
	
	public CartesianCoordinate(double x, double y, double z){
		
		assertClassInvariants();
			
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void assertClassInvariants() {
		// TODO Auto-generated method stub
		assert x != 0 && y != 0 && z != 0; //guarantee a valid coordinate
	}

	public double getDistance(Coordinate co) {
		// TODO Auto-generated method stub
		
		assert co != null;  //make sure a Coordinate input
		
		double c1, c2, c3, result;
		if (co instanceof CartesianCoordinate) {
			c1 = ((CartesianCoordinate) co).x;
			c2 = ((CartesianCoordinate) co).y;
			c3 = ((CartesianCoordinate) co).z;
			result = Math.sqrt(Math.pow(c1 - x, 2) + Math.pow(c2 - y, 2) + Math.pow(c3 - z, 2));
			
			Assert.assertTrue("Distance Error!", result >= 0); //make sure to get a right distance;
			
			return result;
		}else return 0;

	}

	public boolean isEqual(Coordinate co) {
		// TODO Auto-generated method stub
		
		assert co != null;
		
		if (((CartesianCoordinate) co).x == x && ((CartesianCoordinate) co).y == y && ((CartesianCoordinate) co).z == z ) {		
			return true;
		}
		return false;
	}

	public Coordinate toSphericCoordinate() {
		// TODO Auto-generated method stub
		double b, l;
		b = Math.atan(z / (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))));
		l = Math.atan(y / x);
		SphericCoordinate sc = new SphericCoordinate(b, l);
		
		Assert.assertTrue("Transformation Error!", sc != null);
		
		return sc;
	}

	public Coordinate toCartesianCoordinate() {
		// TODO Auto-generated method stub
		return this;
	}

}
