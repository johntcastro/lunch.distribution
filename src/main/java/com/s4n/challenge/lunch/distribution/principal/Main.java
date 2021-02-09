package com.s4n.challenge.lunch.distribution.principal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.s4n.challenge.lunch.distribution.exception.CustomException;
import com.s4n.challenge.lunch.distribution.manager.DroneManager;
import com.s4n.challenge.lunch.distribution.service.DistributionService;

//FIXME Class created only for test purposes!
public class Main {
	public static void main(String[] args) throws CustomException {
		String fileText = "";
		try (Stream<String> stream = Files.lines(Paths.get("./src/main/resources/in01.txt"))) {
            fileText = stream.collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		System.out.println("==============");
		System.out.println(fileText);
		System.out.println("==============\n\n");
		
		DistributionService distributionService = new DistributionService(new DroneManager());
		System.out.println(distributionService.processDistributionFile("in01.txt", fileText, 10));
	}
}
