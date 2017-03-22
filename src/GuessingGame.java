//Luis Payan
//Guessing Game
//CS112

import java.text.NumberFormat;
import java.util.Scanner;

public class GuessingGame
{
	//declares
	static Scanner sc = new Scanner(System.in);
	static int goodGuess, badGuess, min, max, timesPlayed;
	static String newNumbers = "y";
	
	public static void main(String[] args) {
		//displays to player he can set two numbers he wants to guess between
		System.out.println("Let's play a guessing Game!");
		System.out.println("We're going to guess a number between 2 numbers that YOU set yourself!");
		
		//do-while
		do {
			//after played for the first time it asks user if he wants to change his numbers he chose
			if (timesPlayed >= 1) {
				System.out.println("Would you like to enter new 'min' and 'max' numbers? (Y or N)");
				newNumbers = sc.next();
			}
			// This variable should be outside of the do loop
			boolean goodValue;
			
			if (newNumbers.equalsIgnoreCase("y")) {
				//lets player know if needs to be greater or lower number
				do {
					goodValue = false;
					System.out.print("Please enter a starting number: ");
					min = sc.nextInt();
					System.out.print("\nNow enter a number greater than your minimium number: ");
					max = sc.nextInt();
					if (max <= min) {
						System.out.println("Your maximum number must be greater than your minimum number.");
						goodValue = false;
					} else
						goodValue = true;	
					
				} while (!goodValue);
				
				System.out.println("\nThank you! The computer will now generate a random number according to the values you set.");
			}
			
			System.out.println("Please enter a number that you think the computer has chosen from the numbers " + min + " to " + max);
			//displays to try agin if worng
			playARound(min, max);
		} while (askForAnotherRound("Try again!"));
		
		System.out.println("\nThank you for playing the guessing game!\nYour results are listed below...");
		
		// Results and Scores
		System.out.println("\n================================");
		System.out.println("Correct Guesses: " + goodGuess);
		System.out.println("Times Played: " + timesPlayed);
		double grade = (double)goodGuess / (double)timesPlayed;
		NumberFormat winPercent = NumberFormat.getPercentInstance();
		System.out.println("Win Percentage: " + winPercent.format(grade));
		System.out.println("================================");
	}
	
	public static void playARound(int min, int max) {
		
		int number, guess;
		
		// Pick a random number
		number = getRandomNumber(min, max);
		
		// Get the Guess
		guess = getGuess(min, max);
		
		// Check the guess
		if (guess == number) {
			System.out.println("~~~~~~~~~~~~YES! YOU WIN~~~~~~~~~~~");
			goodGuess++;
			timesPlayed++;
		} else {
			System.out.println("Sorry, that is incorrect. The number was " + number);
			badGuess++;
			timesPlayed++;
		}
	}
	
	public static int getRandomNumber(int min, int max) {
		return (int)(Math.random() * (max - min + 1)) + min;
	}

	public static int getGuess(int min, int max) {
		
		while (true) {
			
			int guess = sc.nextInt();
			if ((guess < min) || (guess > max)) {
				if (guess < min)
					System.out.println("Your number must be greater than " + min + ". Please enter a new number: ");
				else
					System.out.println("Your number must be less than " + max + ". Please enter a new number: ");
			} else
				return guess;
		}
	}
	
	public static boolean askForAnotherRound(String prompt) {
		//how about while (answer.equalsIgnoreCase("y"))
		while (true) {
			
			String answer;
			
			System.out.println("\n" + prompt + " (Y or N ) ");
			answer = sc.next();
			if (answer.equalsIgnoreCase("y"))
				return true;
			else if (answer.equalsIgnoreCase("n")) 
				return false;
		}
	}
	
}//end app
