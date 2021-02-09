package com.s4n.challenge.lunch.distribution.util;

import com.s4n.challenge.lunch.distribution.exception.CustomException;

public class Utils {

	public static String getDroneIdFromFileName(String fileName) throws CustomException  {
		try {
			return fileName.substring(fileName.indexOf("in"), fileName.indexOf("."));
		} catch (Exception e) {
			throw new CustomException("Invalid file name -> " + fileName);
		}
	}
	
	public static void writeToFile(String droneId, String outMessage) {
				
	}

}
