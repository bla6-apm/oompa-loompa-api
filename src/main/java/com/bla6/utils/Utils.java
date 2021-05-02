package com.bla6.utils;

import de.svenjacobs.loremipsum.LoremIpsum;

import java.util.Random;

public class Utils {
	public static boolean isNumeric(String data)
	{
        return data.matches("[0-9]+");
	}

	public static String generateRandomName() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		return random.ints(leftLimit, rightLimit + 1)
				.limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
	}

	public static int getRandomNumberUsingInts() {
		Random random = new Random();
		return random.ints(10, 60)
				.findFirst()
				.getAsInt();
	}
	
	public static String getDescription() {
		LoremIpsum lorem = new LoremIpsum();
		return lorem.getWords(40);
	}
}
