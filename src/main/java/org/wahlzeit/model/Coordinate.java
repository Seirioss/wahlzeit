package org.wahlzeit.model;

import org.hamcrest.core.Is;

public interface Coordinate {
	
	public double getDistance(Coordinate co);
	
	public boolean isEqual(Coordinate co);
	
}
