package com.s4n.challenge.lunch.distribution.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import com.s4n.challenge.lunch.distribution.manager.DroneManager;

public class DistributionServiceTest {

	DistributionService distributionService = new DistributionService(new DroneManager());

	@Test
	public void s4nOriginalInputDataTest() throws Exception {
		String fileText = new String(Files.readAllBytes(Paths.get("./src/test/resources/in01.txt")));
		String result = distributionService.processDistributionFile("in01.txt", fileText, 10);

		assertEquals("(-2, 4) dirección Occidente(-1, 3) dirección Sur(0, 0) dirección Occidente", result.replace(System.lineSeparator(), ""));
	}

	@Test
	public void s4nOriginalOutputDataTest() throws Exception {
		String fileText = new String(Files.readAllBytes(Paths.get("./src/test/resources/in02.txt")));
		String result = distributionService.processDistributionFile("in02.txt", fileText, 10);

		assertEquals("(-2, 4) dirección Norte(-3, 3) dirección Sur(-4, 2) dirección Oriente", result.replace(System.lineSeparator(), ""));
	}

	@Test
	public void droneDeliveryLimitTest() throws Exception {
		String fileText = new String(Files.readAllBytes(Paths.get("./src/test/resources/in03.txt")));
		String result = distributionService.processDistributionFile("in03.txt", fileText, 10);

		assertEquals("(-2, 4) dirección NorteDrone out of limits, returning to the restaurant", result.replace(System.lineSeparator(), ""));
	}
}
