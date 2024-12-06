package Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class GenerateRandomString {

	public String random_string() {
		try {
			String randomString = RandomStringUtils.randomAlphabetic(6, 8);
			return randomString;

		} catch (Exception e) {
			return e.getMessage();
		}

	}
}
