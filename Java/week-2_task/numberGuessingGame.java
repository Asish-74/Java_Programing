import java.util.Random;
import java.util.Scanner;

public class numberGuessingGame {
    public static void main(String[] args) {
        // Define the range for the random number
        int minRange = 1;
        int maxRange = 100;

        // Generate a random number between minRange and maxRange
        Random random = new Random();
        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

        // Initialize variables
        int userGuess;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've selected a random number between " + minRange + " and " + maxRange + ".Try to guess it!");
        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < minRange || userGuess > maxRange) {
                System.out.println("Please enter a number between " + minRange + " and " + maxRange + ".");
            } else if (userGuess < randomNumber) {
                System.out.println("Your guess is too low. Try again.");
            } else if (userGuess > randomNumber) {
                System.out.println("Your guess is too high. Try again.");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the number " + randomNumber + " correctly in " + attempts + " attempts.");
            }
        }

        scanner.close();
    }
}
