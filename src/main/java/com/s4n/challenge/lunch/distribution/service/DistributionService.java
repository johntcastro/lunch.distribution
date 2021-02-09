package com.s4n.challenge.lunch.distribution.service;

import java.util.Arrays;
import java.util.List;

import com.s4n.challenge.lunch.distribution.exception.CustomException;
import com.s4n.challenge.lunch.distribution.manager.DroneManager;
import com.s4n.challenge.lunch.distribution.util.Utils;

public class DistributionService {

	DroneManager droneManager;
	
	public DistributionService(DroneManager droneManager) {
		this.droneManager = droneManager;
	}

	public String processDistributionFile(String fileName, String fileText, int blockRestriction) throws CustomException {
		String outMessage = "";
		String droneId = Utils.getDroneIdFromFileName(fileName);
		List<String> instructionsList = Arrays.asList(fileText.split(System.lineSeparator()));

		outMessage = droneManager.processDroneDistribution(droneId, instructionsList, blockRestriction);

		Utils.writeToFile(droneId, outMessage);
		
		return outMessage;
	}
}