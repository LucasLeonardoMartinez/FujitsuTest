package util;

import java.util.ArrayList;
import java.util.List;

public class AcronymGenerator {
	/**
	 * Simple code to solve the following problem: Given a group of letters, print
	 * all existing acronyms. For example: {a,b,c} => abc; acb; bac; bca; cab; cba
	 * 
	 * @param input the string to be used by the method to get all acronyms.
	 * @return a list of all acronyms for the input string.
	 */
	public static List<String> processAcronyms(String input) {
		return processAcronyms(input, new ArrayList<String>(), "");
	}

	/**
	 * 
	 * @param input   the string to be used by the method to get all acronyms.
	 * @param results collection of strings containing all current acronyms.
	 * @param acronym current acronym (for recursive calls).
	 * @return a list of all acronyms for the input string.
	 */
	private static List<String> processAcronyms(String input, List<String> results, String acronym) {

		// If the input's length is 0, it means the method has processed the last
		// character already, so it adds the acronym to the results list.
		if (input != null && input.length() == 0) {
			results.add(acronym);
			return results;
		}

		// Iterate through the input.
		for (int i = 0; i < input.length(); i++) {

			// Current character as char.
			char ch = input.charAt(i);

			// Sets the remaining of the input string to a new variable, in order to use it
			// in the recursive method call.
			String remainingInput = input.substring(0, i) + input.substring(i + 1);

			// Calling the processAcronyms method again for recursive iterations.
			processAcronyms(remainingInput, results, acronym + ch);
		}
		return results;
	}
}
