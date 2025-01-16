import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        // Step 1: Generate a random number within a specified range
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; // Random number between 1 and 100

        Scanner scanner = new Scanner(System.in);
        int userGuess = 0;

        System.out.println("=== Welcome to the Number Guessing Game! ===");
        System.out.println("I have picked a number between 1 and 100. Can you guess it?");

        // Step 4: Repeat until the user guesses the correct number
        while (true) {
            // Step 2: Prompt the user to enter their guess
            System.out.print("Enter your guess: ");

            // Check if input is valid
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                scanner.next(); // Discard invalid input
                continue;
            }

            userGuess = scanner.nextInt();

            // Step 3: Compare the user's guess with the generated number
            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
                break; // Exit the loop
            } else if (userGuess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Too low! Try again.");
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
