package org.wahlzeit.model;

@Pattern (
		name = "Template Method", 
		participants = { 
				"AbstractClass" 
				})

public abstract class AbstractCoordinate implements Coordinate {
	
	public static final int RADIUS = 6731;
	
	public abstract Coordinate toSphericCoordinate();
	
	public abstract Coordinate toCartesianCoordinate();
	
}
