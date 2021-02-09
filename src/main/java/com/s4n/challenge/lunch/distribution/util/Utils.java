package com.s4n.challenge.lunch.distribution.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.s4n.challenge.lunch.distribution.exception.CustomException;

public class Utils {

	public static String getDroneIdFromFileName(String fileName) throws CustomException  {
		try {
			return fileName.substring(fileName.indexOf("in") + 2, fileName.indexOf("."));
		} catch (Exception e) {
			throw new CustomException("Invalid file name -> " + fileName);
		}
	}

	public static void writeToFile(String outputPath, String droneId, String outMessage) throws CustomException {
		File directory = new File(outputPath);
		if (! directory.exists()){
			directory.mkdir();
		}

		String filePath = outputPath + "/out" + droneId + ".txt";
		try {
			Files.write(Paths.get(filePath), outMessage.getBytes());
		} catch (IOException e) {
			throw new CustomException("Error writing file -> " + filePath);
		}
	}

}
