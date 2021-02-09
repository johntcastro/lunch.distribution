package com.s4n.challenge.lunch.distribution.manager;

import java.util.List;

import com.s4n.challenge.lunch.distribution.enums.Instruction;
import com.s4n.challenge.lunch.distribution.enums.Orientation;
import com.s4n.challenge.lunch.distribution.exception.CustomException;
import com.s4n.challenge.lunch.distribution.model.Drone;

public class DroneManager {

	public String processDroneDistribution(String droneId, List<String> instructionsList, int blockRestriction) {
		String outMessage = "";
		Drone drone = new Drone(droneId, 0, 0, Orientation.N);
		for(String delivery : instructionsList) {
			try {
				outMessage += processLunchDelivery(drone, delivery, blockRestriction);
			} catch (CustomException e) {
				outMessage += e.getMessage();
				break;
			}
			outMessage += System.lineSeparator();
		}

		return outMessage;
	}

	private String processLunchDelivery(Drone drone, String delivery, int blockRestriction) throws CustomException {
		for(String instructionString : delivery.split("")) {
			Instruction instruction = Instruction.valueOf(instructionString);
			switch(instruction) {
			case A:
				drone.move();
				break;
			case I:
				drone.turnLeft();
				break;
			case D:
				drone.turnRight();
				break;
			}

			validateDronePosition(drone, blockRestriction);
		}

		return drone.getPositionAsString();
	}

	private void validateDronePosition(Drone drone, int blockRestriction) throws CustomException {
		if(Math.abs(drone.getPositionX()) > blockRestriction || Math.abs(drone.getPositionY()) > blockRestriction) {
			throw new CustomException("Drone out of limits, returning to the restaurant");
		}
	}
}
