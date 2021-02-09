package com.s4n.challenge.lunch.distribution.model;

import com.s4n.challenge.lunch.distribution.enums.Orientation;

public class Drone {
	private String droneId;
	private int positionX;
	private int positionY;
	private Orientation orientation;

	public Drone(String droneId, int x, int y, Orientation orientation) {
		this.droneId = (droneId);
		this.positionX = x;
		this.positionY = y;
		this.orientation = orientation;
	}

	public String getPositionAsString() {
		return "(" + 
				getPositionX() + 
				", " + 
				getPositionY() + 
				") dirección " +
				getOrientationName();
	}

	public void move() {
		switch(getOrientation()) {
		case N:
			addPositionY(1);
			break;
		case W:
			addPositionX(-1);
			break;
		case S:
			addPositionY(-1);
			break;
		case E:
			addPositionX(1);
			break;
		}
	}

	public void turnLeft() {
		switch(getOrientation()) {
		case N:
			setOrientation(Orientation.W);
			break;
		case W:
			setOrientation(Orientation.S);
			break;
		case S:
			setOrientation(Orientation.E);
			break;
		case E:
			setOrientation(Orientation.N);
			break;
		}
	}

	public void turnRight() {
		switch(getOrientation()) {
		case N: 
			setOrientation(Orientation.E);
			break;
		case E:
			setOrientation(Orientation.S);
			break;
		case S:
			setOrientation(Orientation.W);
			break;
		case W:
			setOrientation(Orientation.N);
			break;
		}
	}

	public String getDroneId() {
		return droneId;
	}

	public void setDroneId(String droneId) {
		this.droneId = droneId;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public void addPositionX(int i) {
		positionX = positionX + i;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public void addPositionY(int i) {
		positionY = positionY + i;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public String getOrientationName() {
		return orientation.getName();
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
}