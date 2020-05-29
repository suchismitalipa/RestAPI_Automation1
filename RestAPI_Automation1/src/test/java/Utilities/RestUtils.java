package Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	public static String empName() {
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return("John"+generatedString);
		}
	public static String empAge() {
		String generatedInt = RandomStringUtils.randomNumeric(2);
		return(generatedInt);
		}
	public static String empSalary() {
		String generatedString = RandomStringUtils.randomNumeric(5);
		return(generatedString);
		}

}
