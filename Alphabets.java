//Name: Chand Babu Haryani
// Generates a random letter and asks the user what letter is generated
// created for helping kids to recognize different letters.

import java.util.Random;
import java.util.Scanner;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import javax.speech.*;
import javax.speech.recognition.*;
import java.io.FileReader;
import java.util.Locale;

public class Alphabets {
	public static char[] upperAlpha, lowerAlpha, randomAlpha;
	public static String cas;

	public static void main(String[] args) throws Exception {

		// array of uppercase Alphabets
		char[] upperAlpha = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z' };
		// array of lowercase Alphabets
		char[] lowerCase = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z' };
		// array of both alphabets
		char[] randomAlpha = { 'A', 'a', 'B', 'b', 'C', 'c', 'D', 'd', 'E',
				'e', 'F', 'f', 'G', 'g', 'H', 'h', 'I', 'i', 'J', 'j', 'K',
				'k', 'L', 'l', 'M', 'm', 'N', 'n', 'O', 'o', 'P', 'p', 'Q',
				'q', 'R', 'r', 'S', 's', 'T', 't', 'U', 'u', 'V', 'v', 'W',
				'w', 'X', 'x', 'Y', 'y', 'Z', 'z' };

		Scanner input = new Scanner(System.in);
		final char o = randomChar(randomAlpha);
		System.out.println("The randomdom letter generated is: " + o);

		// using VoiceManager from FreeTTS API to convert text to speech
		VoiceManager v = VoiceManager.getInstance();
		Voice voice = v.getVoice("kevin16");
		voice.allocate();
		System.out.println("Computer: what letter is it? ");
		voice.speak("What letter is it ?");

		System.out.print("User input: ");
		char c = input.next().charAt(0);

		Boolean var = false;

		boolean sentinel = false;
		while (c != o) {
			System.out
					.println("Computer: You haven't gotten the right letter, Please try again");
			voice.speak("You haven't gotten the right letter, Please try again");
			System.out.print("User input: ");
			c = input.next().charAt(0);
			if (c == o) {
				break;
			}
		}
		if (c == o) {
			System.out
					.println("Computer: You got it correct. Is it an Uppercase or Lowercase?");
			voice.speak("You got it correct. Is it an Uppercase or Lowercase");
		}
		System.out.print("User input: ");
		cas = input.next();
		boolean is = true;

		for (int i = 0; i < 26; i++) {
			if (o == upperAlpha[i]) {
				System.out.println("Computer: It's Uppercase");
				voice.speak(("It's Uppercase"));
				is = true;
				break;
			}
			is = false;
		}

		if (is == false) {
			System.out.println("Computer: It's Lowercase");
			voice.speak(("It's Lowercase"));
		}

		System.out.println("Computer: Is it a vowel or consonant? ");
		voice.speak("Is it a vowel or consonant? ");
		System.out.print("User input: ");
		String vInput = input.next();
		boolean myVar = false;

		if (o == 'A' || o == 'E' || o == 'I' || o == 'O' || o == 'U'
				|| o == 'a' || o == 'e' || o == 'i' || o == 'o' || o == 'u') {
			System.out.println("Computer: It's a vowel");
			voice.speak("It's a vowel");

		} else {
			System.out.println("Computer: It's a consonant");
			voice.speak("It's a consonant");
		}
		System.exit(0);
	}

	// generates a random character from an array(randomAlpha)
	public static char randomChar(char c[]) {
		int cp = 0;
		cp = (int) (Math.random() * c.length);
		char cc = 0;
		for (int i = 0; i < 26; i++) {
			cc = c[cp];

		}

		return cc;
	}

}
	
