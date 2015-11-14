package org.wahlzeit.model;

import javax.security.auth.PrivateCredentialPermission;

public class CartesianCoordinate extends AbstractCoordinate{
	
	private double x;
	private double y;
	private double z;
	
	public CartesianCoordinate(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getDistance(Coordinate co) {
		// TODO Auto-generated method stub
		double c1, c2, c3
		if (co instanceof CartesianCoordinate) {
			c1 = ((CartesianCoordinate) co).x;
			c2 = ((CartesianCoordinate) co).y;
			c3 = ((CartesianCoordinate) co).z;
			return Math.sqrt(Math.pow(c1 - x, 2) + Math.pow(c2 - y, 2) + Math.pow(c3 - z, 2));
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
		double b, l;
		b = Math.atan(z / (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))));
		l = Math.atan(y / x);
		return new SphericCoordinate(b, l);
	}

	public Coordinate toCartesianCoordinate() {
		// TODO Auto-generated method stub
		return this;
	}

}
