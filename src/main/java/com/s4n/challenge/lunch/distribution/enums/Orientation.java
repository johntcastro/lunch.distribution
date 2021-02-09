package com.s4n.challenge.lunch.distribution.enums;

public enum Orientation {
	N("Norte"), S("Sur"), E("Oriente"), W("Occidente");

	private String orientationName;
	
	Orientation(String orientationName) {
		this.orientationName = orientationName;
	}

	public String getName() {
		return this.orientationName;
	}
}